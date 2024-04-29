package com.picpay.core.parser.visitor;

import com.picpay.core.domain.CrdLivre;
import com.picpay.core.domain.CrdPes;
import com.picpay.core.domain.Diario;
import com.picpay.core.domain.DocTxb;
import com.picpay.core.domain.PesFisica;
import com.picpay.core.domain.Pre;
import com.picpay.core.domain.Referencia;

public interface TagVisitor {
  void visitDocTxb(final DocTxb docTxb);
  void visitReferencia(final Referencia referencia);
  void visitDiario(final Diario diario);
  void visitCrdLivre(final CrdLivre crdLivre);
  void visitPesFisica(final PesFisica pesFisica);
  void visitPre(final Pre pre);
  void visitCrdLivrePf(final CrdPes crdPes);
}
