package com.yaic.app.order.enums;

public enum AgrtCodeEnums {
	AGRTCODE_2202_001("080000000376220201"),
	AGRTCODE_2202_002("080000000376220202"),
	AGRTCODE_2213_001("080000000376221301"),
	AGRTCODE_3409_001("03409001001000"),
	AGRTCODE_3409_002("03409001002000"),
	AGRTCODE_3409_003("03409001003000"),
	AGRTCODE_3405_001("03405005008000"),
	AGRTCODE_3405_002("03405005009000"),
	AGRTCODE_3417_001("03417001001000"),
	AGRTCODE_3417_002("03417001002000"),
	AGRTCODE_3417_003("03417001003000"),
	AGRTCODE_3412_001("03412002001000"),
	AGRTCODE_3412_002("03412002004000"),
	AGRTCODE_3412_003("03412002005000"),
	AGRTCODE_3008_001("20173008001A0007"),
	AGRTCODE_3008_002("20173008002B0007");
	public String agrtCode;

	AgrtCodeEnums(String agrtCode) {
		this.agrtCode = agrtCode;
	}
	
	/**
	 * 协议号
	 * <p>User: lshuang
	 * <p>Date: 2018-1-3
	 * <p>Version: 1.0
	 * @param agrtCode
	 * @return
	 */
    public static boolean fromArgtCode(String agrtCode){
        for (AgrtCodeEnums reqType:AgrtCodeEnums.values()){
            if (reqType.agrtCode.equals(agrtCode)){
                return true;
            }
        }
        return false;
    }
}
