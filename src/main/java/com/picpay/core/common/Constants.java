package com.picpay.core.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
  public static final String CNPJ_REGEX = "^\\d{8}$";
  public static final String CPF_REGEX = "^\\d{11}$";
  public static final String TEL_REGEX = "^\\d{10}$";
  public static final String MONEY_REGEX = "^[0-9]+\\.[0-9]{2}$";
  public static final String TX_MED_ENCARGOS = "^[0-9]{1}\\.[0-9]{2}$";
  public static final String CNPJ_PPBANK = "09516419";

  public static final String DOC_TXB = "DocTXB";
  public static final String REFERENCIA = "referencia";
  public static final String CRD_LIVRE = "crdLivre";
  public static final String DIARIO = "diario";
  public static final String PES_FISICA = "pesFisica";
  public static final String PRE = "pre";
  public static final String CRD_PES_NAO_CONSIGNADO = "crdPesNaoConsignado";
  public static final String CRD_PES_NAO_CON_VIN_COMPOSICAO = "crdPesNaoConVinComposicao";
  public static final String CRD_PES_CON_TRA_SET_PUBLICO = "crdPesConTraSetPublico";
  public static final String CRD_PES_CON_APO_INSS = "crdPesConApoINSS";
}
