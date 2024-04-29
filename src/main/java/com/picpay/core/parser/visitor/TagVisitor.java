package com.picpay.core.parser.visitor;

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

public interface TagVisitor {
  void visitDocTxb(final DocTxb docTxb);
  void visitReferencia(final Referencia referencia);
  void visitDiario(final Diario docTxb);
  void visitCrdLivre(final CrdLivre docTxb);
  void visitPesFisica(final PesFisica docTxb);
  void visitPre(final Pre docTxb);
  void visitCrdPesNaoConsignado(final CrdPesNaoConsignado docTxb);
  void visitCrdPesNaoConVinComposicao(final CrdPesNaoConVinComposicao docTxb);
  void visitCrdPesConTraSetPublico(final CrdPesConTraSetPublico docTxb);
  void visitCrdPesConApoINSS (final CrdPesConApoINSS docTxb);
}
