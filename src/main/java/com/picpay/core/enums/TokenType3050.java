package com.picpay.core.enums;

public enum TokenType3050 {
  XML("xml"),
  VERSION("version"),
  ENCODING("encoding"),

  DOC_TXB("DocTXB"),
  CNPJ_INSTITUICAO("cnpjInstituicao"),
  DATA_BASE("dataBase"),
  IND_REMESSA("indRemessa"),
  NM_CONTATO("nmContato"),
  TEL_CONTATO("telContato"),

  REFERENCIA("referencia"),
  DATA_REF("dataRef"),

  DIARIO("diario"),
  CRD_LIVRE("crdLivre"),
  PES_FISICA("pesFisica"),

  PRE("pre"),
  CRD_PES_NAO_CONSIGNADO("crdPesNaoConsignado"),
  TX_MED_JUROS("txMedJuros"),
  TX_MED_ENC_FISCAIS("txMedEncFiscais"),
  TX_MED_ENC_OPERACIONAIS("txMedEncOperacionais"),
  VLR_CONCESSOES("vlrConcessoes"),
  PRZ_DEC_MED_CONCESSOES("przDecMedConcessoes"),
  SLD_CAR_ATIVA("sldCarAtiva"),

  CRD_PES_NAO_CON_VIN_COMPOSICAO("crdPesNaoConVinComposicao"),
  CRD_PES_CON_TRA_SET_PUBLICO("crdPesConTraSetPublico"),
  CRD_PES_CON_APO_INSS("crdPesConApoINSS");

  private final String key;

  TokenType3050(final String key) {
    this.key = key;
  }

  public String key() {
    return this.key;
  }
}
