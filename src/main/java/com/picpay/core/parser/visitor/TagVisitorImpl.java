package com.picpay.core.parser.visitor;

import com.picpay.core.domain.CrdLivre;
import com.picpay.core.domain.CrdLivrePF;
import com.picpay.core.domain.Diario;
import com.picpay.core.domain.DocTxb;
import com.picpay.core.domain.PesFisica;
import com.picpay.core.domain.Pre;
import com.picpay.core.domain.Referencia;
import com.picpay.core.parser.validators.CrdLivrePFValidator;
import com.picpay.core.parser.validators.CrdLivreValidator;
import com.picpay.core.parser.validators.DiarioValidator;
import com.picpay.core.parser.validators.DocTxbValidator;
import com.picpay.core.parser.validators.PesFisicaValidator;
import com.picpay.core.parser.validators.PreValidator;
import com.picpay.core.parser.validators.ReferenciaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TagVisitorImpl implements TagVisitor {
  private final DocTxbValidator docTxbValidator;
  private final ReferenciaValidator referenciaValidator;
  private final DiarioValidator diarioValidator;
  private final CrdLivreValidator crdLivreValidator;
  private final PesFisicaValidator pesFisicaValidator;
  private final PreValidator preValidator;
  private final CrdLivrePFValidator crdLivrePfValidator;

  @Override
  public void visitDocTxb(final DocTxb docTxb) {
    docTxbValidator.accept(docTxb);
  }

  @Override
  public void visitReferencia(final Referencia referencia) {
    referenciaValidator.accept(referencia);
  }

  @Override
  public void visitDiario(final Diario diario) {
    diarioValidator.accept(diario);
  }

  @Override
  public void visitCrdLivre(final CrdLivre crdLivre) {
    crdLivreValidator.accept(crdLivre);
  }

  @Override
  public void visitPesFisica(final PesFisica pesFisica) {
    pesFisicaValidator.accept(pesFisica);
  }

  @Override
  public void visitPre(final Pre pre) {
    preValidator.accept(pre);
  }

  @Override
  public void visitCrdLivrePf(final CrdLivrePF crdLivrePf) {
    crdLivrePfValidator.accept(crdLivrePf);
  }
}
