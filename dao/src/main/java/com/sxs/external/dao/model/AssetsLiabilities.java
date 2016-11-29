package com.sxs.external.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class AssetsLiabilities implements Serializable {
	private static final long serialVersionUID = -1996879845809529757L;
	private Integer id;
	private String stkcd;
	private Date accper;
	private String typrep;
	private String indcd;
	private BigDecimal f011201a;
}
