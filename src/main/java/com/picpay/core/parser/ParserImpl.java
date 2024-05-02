package com.picpay.core.parser;

import com.picpay.core.domain.CrdLivre;
import com.picpay.core.domain.CrdPesConApoINSS;
import com.picpay.core.domain.CrdPesConTraSetPublico;
import com.picpay.core.domain.CrdPesNaoConVinComposicao;
import com.picpay.core.domain.CrdPesNaoConsignado;
import com.picpay.core.domain.Diario;
import com.picpay.core.domain.DocTxb;
import com.picpay.core.domain.PesFisica;
import com.picpay.core.domain.Pre;
import com.picpay.core.domain.Referencia;
import com.picpay.core.exceptions.ParserException;
import com.picpay.core.log.SimpleLog;
import com.picpay.core.parser.stack.TagStack;
import com.picpay.core.parser.visitor.TagVisitor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.picpay.core.common.Constants.CRD_LIVRE;
import static com.picpay.core.common.Constants.CRD_PES_CON_APO_INSS;
import static com.picpay.core.common.Constants.CRD_PES_CON_TRA_SET_PUBLICO;
import static com.picpay.core.common.Constants.CRD_PES_NAO_CONSIGNADO;
import static com.picpay.core.common.Constants.CRD_PES_NAO_CON_VIN_COMPOSICAO;
import static com.picpay.core.common.Constants.DIARIO;
import static com.picpay.core.common.Constants.DOC_TXB;
import static com.picpay.core.common.Constants.PES_FISICA;
import static com.picpay.core.common.Constants.PRE;
import static com.picpay.core.common.Constants.REFERENCIA;
import static com.picpay.core.enums.LogType.ERROR;
import static com.picpay.core.enums.LogType.INFO;

@Slf4j
@Component
@RequiredArgsConstructor
public class ParserImpl implements Parser, SimpleLog {
  private final TagVisitor tagVisitor;
  private final TagStack stack;

  @Override
  @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.MINUTES)
  public void processFile() {
    final var resource = new ClassPathResource("cadoc3050.xml");
    final var xmlInputFactory = XMLInputFactory.newInstance();

    try {
      final var reader = xmlInputFactory.createXMLEventReader(new FileInputStream(resource.getFile()));

      if (!reader.hasNext()) return;

      XMLEvent nextEvent;
      DocTxb docTxb = null;
      Referencia referencia = null;
      Diario diario = null;
      CrdLivre crdLivre = null;
      PesFisica pesFisica = null;
      Pre pre = null;

      while (reader.hasNext()) {
        nextEvent = reader.nextEvent();

        if (nextEvent.isStartElement()) {
          final var startElement = nextEvent.asStartElement();
          final var tagName = startElement.getName().getLocalPart();

          switch (tagName) {
            case DOC_TXB:
              docTxb = new DocTxb(nextEvent);
              stack.push(docTxb);
              docTxb.accept(tagVisitor);
              break;
            case REFERENCIA:
              referencia = new Referencia(nextEvent, docTxb);
              stack.push(referencia);
              referencia.accept(tagVisitor);
              break;
            case CRD_LIVRE:
              crdLivre = new CrdLivre(nextEvent, diario);
              stack.push(crdLivre);
              crdLivre.accept(tagVisitor);
              break;
            case DIARIO:
              diario = new Diario(nextEvent, referencia);
              stack.push(diario);
              diario.accept(tagVisitor);
              break;
            case PES_FISICA:
              pesFisica = new PesFisica(nextEvent, crdLivre);
              stack.push(pesFisica);
              pesFisica.accept(tagVisitor);
              break;
            case PRE:
              pre = new Pre(nextEvent, pesFisica);
              stack.push(pre);
              pre.accept(tagVisitor);
              break;
            case CRD_PES_NAO_CONSIGNADO:
              final var crdPesNaoConsignado = new CrdPesNaoConsignado(nextEvent, pre);
              stack.push(crdPesNaoConsignado);
              crdPesNaoConsignado.accept(tagVisitor);
              break;
            case CRD_PES_NAO_CON_VIN_COMPOSICAO:
              final var crdPesNaoConVinComposicao = new CrdPesNaoConVinComposicao(nextEvent, pre);
              stack.push(crdPesNaoConVinComposicao);
              crdPesNaoConVinComposicao.accept(tagVisitor);
              break;
            case CRD_PES_CON_TRA_SET_PUBLICO:
              final var crdPesConTraSetPublico = new CrdPesConTraSetPublico(nextEvent, pre);
              stack.push(crdPesConTraSetPublico);
              crdPesConTraSetPublico.accept(tagVisitor);
              break;
            case CRD_PES_CON_APO_INSS:
              final var crdPesConApoINSS = new CrdPesConApoINSS(nextEvent, pre);
              stack.push(crdPesConApoINSS);
              crdPesConApoINSS.accept(tagVisitor);
              break;
            default:
              ignoredTag(tagName);
          }
        } else if (nextEvent.isEndElement()) {
          final var endElement = nextEvent.asEndElement();
          final var tagName = endElement.getName().getLocalPart();

          switch (tagName) {
            case DOC_TXB:
              stack.pop(DOC_TXB);
              docTxb = null;
              break;
            case REFERENCIA:
              stack.pop(REFERENCIA);
              referencia = null;
              break;
            case CRD_LIVRE:
              stack.pop(CRD_LIVRE);
              crdLivre = null;
              break;
            case DIARIO:
              stack.pop(DIARIO);
              diario = null;
              break;
            case PES_FISICA:
              stack.pop(PES_FISICA);
              pesFisica = null;
              break;
            case PRE:
              stack.pop(PRE);
              pre = null;
              break;
            case CRD_PES_NAO_CONSIGNADO:
              stack.pop(CRD_PES_NAO_CONSIGNADO);
              break;
            case CRD_PES_NAO_CON_VIN_COMPOSICAO:
              stack.pop(CRD_PES_NAO_CON_VIN_COMPOSICAO);
              break;
            case CRD_PES_CON_TRA_SET_PUBLICO:
              stack.pop(CRD_PES_CON_TRA_SET_PUBLICO);
              break;
            case CRD_PES_CON_APO_INSS:
              stack.pop(CRD_PES_CON_APO_INSS);
              break;
            default:
              ignoredTag(tagName);
          }
        }
      }
    } catch (final XMLStreamException | IOException e) {
      throw new ParserException("Erro ao processar arquivo", e);
    }
  }

  private void unexpectedTag(final String tagName) {
    log.error(log(ERROR, "Tag " + tagName + " não esperada."));
  }

  private void ignoredTag(final String tagName) {
    log.info(log(INFO, "Tag ignorada: " + tagName));
  }
}
