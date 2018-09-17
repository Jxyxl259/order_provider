package com.yaic.app.epolicy.dto.domain;

import javax.persistence.Transient;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ROOT")
public class EpolicyRootDto {

	/** 公司logo */
	@XStreamAlias("LOGOIMAGE")
	private String logoImage;
	
	/** 官微二维码 */
	@XStreamAlias("WEIXINIMAGE")
	private String weixinImage;
	
	/** 电子签章 */
	@XStreamAlias("SEAL")
	private String seal;
	
	/** 文件名称 */
	@XStreamAlias("FILENAME")
	private String fileName;
	
	/** 模板id */
	@XStreamAlias("insuranceCode")
	private String insuranceCode;
	
	/** 是否测试单 */
	@XStreamAlias("ISTEST")
	private String isTest;
	
	/** 保单号 */
	@XStreamAlias("policyNo")
	private String policyNo;
	
	/** 打印时间 */
	@XStreamAlias("PRINTDATE")
	private String printDate;
	
	/** 保单生成时间 */
	@XStreamAlias("ACCEPTDATE")
	private String acceptDate;
	
	/** 签单时间 */
	@XStreamAlias("ISSUEDATE")
	private String issueDate;
	
	/** 起保日期-年 */
	@XStreamAlias("STARTYEAR")
	private String startYear;
	
	/** 起保日期-月 */
	@XStreamAlias("STARTMONTH")
	private String startMonth;
	
	/** 起保日期-天 */
	@XStreamAlias("STARTDAY")
	private String startDay;
	
	/** 起保日期-时间 */
	@XStreamAlias("STARTTIME")
	private String startTime;
	
	/** 终保日期-年 */
	@XStreamAlias("ENDYEAR")
	private String endYear;
	
	/** 终保日期-月 */
	@XStreamAlias("ENDMONTH")
	private String endMonth;
	
	/** 终保日期-天 */
	@XStreamAlias("ENDDAY")
	private String endDay;
	
	/** 终保日期-时间 */
	@XStreamAlias("ENDTIME")
	private String endTime;
	
	/** 保期天数 */
	@XStreamAlias("PERIOD")
	private String period;
	
	/** 投保人信息 */
	@XStreamAlias("APPLYINFOR")
	private EpolicyApplyRoot applyInfor;
	
	/** 被保险总人数 */
	@XStreamAlias("INSUREDCOUNT")
	private String insuredCount;
	
	/** 被保人信息 */
	@XStreamAlias("INSURED")
	private EpolicyInsuredRoot insured;
	
	/** 受益人信息 */
	@XStreamAlias("BENEFIT")
	private EpolicyBenefitRoot benefit;
	
	/** 标的信息 */
	@XStreamAlias("ITEM")
	private EpolicyDynamicItemRoot dynamicItem;
	
	/** 货运险标的详细信息 */
	@XStreamAlias("ITEMCARGODTL")
	private EpolicyItemCargoRoot itemCargoDtl;
	
	/** 动态标的清单信息 */
	@XStreamAlias("ITEMLIST")
	private EpolicyDynamicListRoot itemList;
	
	/** 所有险信息 */
	@XStreamAlias("ALLKIND")
	private EpolicyAllKindRoot allKind;
	
	/** 主险信息 */
	@XStreamAlias("MAINKIND")
	private EpolicyMainKindRoot mainKind;
	
	/** 附加险信息 */
	@XStreamAlias("MINORKIND")
	private EpolicyMinorKindRoot minorKind;
	
	/** 份数信息 */
	@XStreamAlias("AVGPREM")
	private EpolicyAvgpremRoot avgprem;
	
	/** 币别 */
	@XStreamAlias("CURRENCY")
	private String currency;
	
	/** 总保额大写 */
	@XStreamAlias("UPPSUMINSURED")
	private String uppsumInsured;
	
	/** 总保额 */
	@XStreamAlias("SUMINSURED")
	private String sumInsured;
	
	/** 总保费大写 */
	@XStreamAlias("UPPSUMGROSSPREMIUM")
	private String uppSumGrossPremium;
	
	/** 总保费 */
	@XStreamAlias("SUMGROSSPREMIUM")
	private String sumGrossPremium;
	
	/** 支付信息 */
	@XStreamAlias("PAYMENT")
	private EpolicyPaymentRoot payment;
	
	/** 追溯起期 */
	@XStreamAlias("RETROACTIVESTARTDATE")
	private String retroActiveStartDate;
	
	/** 追溯止期 */
	@XStreamAlias("RETROACTIVEENDDATE")
	private String retroActiveEndDate;
	
	/** 产品代码 */
	@XStreamAlias("PRODCODE")
	private String prodCode;
	
	/** 产品名称 */
	@XStreamAlias("PRODCNAME")
	private String prodName;
	
	/** 销售方案代码 */
	@XStreamAlias("AGRTCODE")
	private String agrtCode;
	
	/** 销售方案名称 */
	@XStreamAlias("AGRTCNAME")
	private String agrtName;
	
	/** 业务归属 */
	@XStreamAlias("COMPANYCODE")
	private String companyCode;
	
	/** 平台代码 */
	@XStreamAlias("CHANNEL")
	private String channel;
	
	/** 承保区域 */
	@XStreamAlias("GEOGRAPHICALAREA")
	private String geographicalArea;
	
	/** 司法管辖 */
	@XStreamAlias("JUDICALSCOPE")
	private String judicalScope;
	
	/** 争议处理 */
	@XStreamAlias("ARGUESOLUTION")
	private String argueSolution;
	
	/** 免赔 */
	@XStreamAlias("DEDUCTIBLE")
	private String deductible;
	
	/** 特别约定 */
	@XStreamAlias("CLAUSECONTEXT")
	private String clauseconText;
	
	/** 投保说明 */
	@XStreamAlias("APPINSTRUCTIONS")
	private String appInstructions;
	
	/** 健康告知 */
	@XStreamAlias("INFORM")
	private String inform;
	
	/** 条款名称 */
	@XStreamAlias("CLAUSES")
	private String clauses;
	
	/** 条款信息 */
	@XStreamAlias("CLAUSES")
	private EpolicyClausesRoot clausesList;
	
	/** 保险公司 */
	@XStreamAlias("COMPANY")
	private String company;
	
	/** 经营地址 */
	@XStreamAlias("COMPANYADDRESS")
	private String companyAddress;
	
	/** 电话 */
	@XStreamAlias("TELEPHONE")
	private String telephone;
	
	/** 网址 */
	@XStreamAlias("WEBSITE")
	private String website;
	
	/** 重要提示 */
	@XStreamAlias("IMPORTANTPART")	
	private String importantPart;
	
	/** 页脚提示信息 */
	@XStreamAlias("IMPORTANTNOTICE")
	private String importantNotice;
	
	/** 险种代码 */
	@Transient
	private String riskCode;

	/** 公司logo */
	public String getLogoImage() {
		return logoImage;
	}

	/** 公司logo */
	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}

	/** 官微二维码 */
	public String getWeixinImage() {
		return weixinImage;
	}

	/** 官微二维码 */
	public void setWeixinImage(String weixinImage) {
		this.weixinImage = weixinImage;
	}

	/** 电子签章 */
	public String getSeal() {
		return seal;
	}

	/** 电子签章 */
	public void setSeal(String seal) {
		this.seal = seal;
	}

	/** 文件名称 */
	public String getFileName() {
		return fileName;
	}

	/** 文件名称 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/** 模板id */
	public String getInsuranceCode() {
		return insuranceCode;
	}

	/** 模板id */
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	/** 是否测试单 */
	public String getIsTest() {
		return isTest;
	}

	/** 是否测试单 */
	public void setIsTest(String isTest) {
		this.isTest = isTest;
	}

	/** 保单号 */
	public String getPolicyNo() {
		return policyNo;
	}

	/** 保单号 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/** 打印时间 */
	public String getPrintDate() {
		return printDate;
	}

	/** 打印时间 */
	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}

	/** 保单生成时间 */
	public String getAcceptDate() {
		return acceptDate;
	}

	/** 保单生成时间 */
	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}

	/** 签单时间 */
	public String getIssueDate() {
		return issueDate;
	}

	/** 签单时间 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	/** 起保日期-年 */
	public String getStartYear() {
		return startYear;
	}

	/** 起保日期-年 */
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	/** 起保日期-月 */
	public String getStartMonth() {
		return startMonth;
	}

	/** 起保日期-月 */
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	/** 起保日期-天 */
	public String getStartDay() {
		return startDay;
	}

	/** 起保日期-天 */
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	/** 起保日期-时间 */
	public String getStartTime() {
		return startTime;
	}

	/** 起保日期-时间 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/** 终保日期-年 */
	public String getEndYear() {
		return endYear;
	}

	/** 终保日期-年 */
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	/** 终保日期-月 */
	public String getEndMonth() {
		return endMonth;
	}

	/** 终保日期-月 */
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	/** 终保日期-天 */
	public String getEndDay() {
		return endDay;
	}

	/** 终保日期-天 */
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	/** 终保日期-时间 */
	public String getEndTime() {
		return endTime;
	}

	/** 终保日期-时间 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/** 保期天数 */
	public String getPeriod() {
		return period;
	}

	/** 保期天数 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/** 投保人信息 */
	public EpolicyApplyRoot getApplyInfor() {
		return applyInfor;
	}

	/** 投保人信息 */
	public void setApplyInfor(EpolicyApplyRoot applyInfor) {
		this.applyInfor = applyInfor;
	}

	/** 被保险总人数 */
	public String getInsuredCount() {
		return insuredCount;
	}

	/** 被保险总人数 */
	public void setInsuredCount(String insuredCount) {
		this.insuredCount = insuredCount;
	}

	/** 被保人信息 */
	public EpolicyInsuredRoot getInsured() {
		return insured;
	}

	/** 被保人信息 */
	public void setInsured(EpolicyInsuredRoot insured) {
		this.insured = insured;
	}

	/** 受益人信息 */
	public EpolicyBenefitRoot getBenefit() {
		return benefit;
	}

	/** 受益人信息 */
	public void setBenefit(EpolicyBenefitRoot benefit) {
		this.benefit = benefit;
	}

	/** 标的信息 */
	public EpolicyDynamicItemRoot getDynamicItem() {
		return dynamicItem;
	}

	/** 标的信息 */
	public void setDynamicItem(EpolicyDynamicItemRoot dynamicItem) {
		this.dynamicItem = dynamicItem;
	}

	/** 货运险标的详细信息 */
	public EpolicyItemCargoRoot getItemCargoDtl() {
		return itemCargoDtl;
	}

	/** 货运险标的详细信息 */
	public void setItemCargoDtl(EpolicyItemCargoRoot itemCargoDtl) {
		this.itemCargoDtl = itemCargoDtl;
	}

	/** 动态标的清单信息 */
	public EpolicyDynamicListRoot getItemList() {
		return itemList;
	}

	/** 动态标的清单信息 */
	public void setItemList(EpolicyDynamicListRoot itemList) {
		this.itemList = itemList;
	}

	/** 所有险信息 */
	public EpolicyAllKindRoot getAllKind() {
		return allKind;
	}

	/** 所有险信息 */
	public void setAllKind(EpolicyAllKindRoot allKind) {
		this.allKind = allKind;
	}

	/** 主险信息 */
	public EpolicyMainKindRoot getMainKind() {
		return mainKind;
	}

	/** 主险信息 */
	public void setMainKind(EpolicyMainKindRoot mainKind) {
		this.mainKind = mainKind;
	}

	/** 附加险信息 */
	public EpolicyMinorKindRoot getMinorKind() {
		return minorKind;
	}

	/** 附加险信息 */
	public void setMinorKind(EpolicyMinorKindRoot minorKind) {
		this.minorKind = minorKind;
	}

	/** 份数信息 */
	public EpolicyAvgpremRoot getAvgprem() {
		return avgprem;
	}

	/** 份数信息 */
	public void setAvgprem(EpolicyAvgpremRoot avgprem) {
		this.avgprem = avgprem;
	}

	/** 币别 */
	public String getCurrency() {
		return currency;
	}

	/** 币别 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/** 总保额大写 */
	public String getUppsumInsured() {
		return uppsumInsured;
	}

	/** 总保额大写 */
	public void setUppsumInsured(String uppsumInsured) {
		this.uppsumInsured = uppsumInsured;
	}

	/** 总保额 */
	public String getSumInsured() {
		return sumInsured;
	}

	/** 总保额 */
	public void setSumInsured(String sumInsured) {
		this.sumInsured = sumInsured;
	}

	/** 总保费大写 */
	public String getUppSumGrossPremium() {
		return uppSumGrossPremium;
	}

	/** 总保费大写 */
	public void setUppSumGrossPremium(String uppSumGrossPremium) {
		this.uppSumGrossPremium = uppSumGrossPremium;
	}

	/** 总保费 */
	public String getSumGrossPremium() {
		return sumGrossPremium;
	}

	/** 总保费 */
	public void setSumGrossPremium(String sumGrossPremium) {
		this.sumGrossPremium = sumGrossPremium;
	}

	/** 支付信息 */
	public EpolicyPaymentRoot getPayment() {
		return payment;
	}

	/** 支付信息 */
	public void setPayment(EpolicyPaymentRoot payment) {
		this.payment = payment;
	}

	/** 追溯起期 */
	public String getRetroActiveStartDate() {
		return retroActiveStartDate;
	}

	/** 追溯起期 */
	public void setRetroActiveStartDate(String retroActiveStartDate) {
		this.retroActiveStartDate = retroActiveStartDate;
	}

	/** 追溯止期 */
	public String getRetroActiveEndDate() {
		return retroActiveEndDate;
	}

	/** 追溯止期 */
	public void setRetroActiveEndDate(String retroActiveEndDate) {
		this.retroActiveEndDate = retroActiveEndDate;
	}

	/** 产品代码 */
	public String getProdCode() {
		return prodCode;
	}

	/** 产品代码 */
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	/** 产品名称 */
	public String getProdName() {
		return prodName;
	}
	
	/** 产品名称 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	/** 销售方案代码 */
	public String getAgrtCode() {
		return agrtCode;
	}

	/** 销售方案代码 */
	public void setAgrtCode(String agrtCode) {
		this.agrtCode = agrtCode;
	}

	/** 销售方案名称 */
	public String getAgrtName() {
		return agrtName;
	}

	/** 销售方案名称 */
	public void setAgrtName(String agrtName) {
		this.agrtName = agrtName;
	}

	/** 业务归属 */
	public String getCompanyCode() {
		return companyCode;
	}

	/** 业务归属 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/** 平台代码 */
	public String getChannel() {
		return channel;
	}

	/** 平台代码 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/** 承保区域 */
	public String getGeographicalArea() {
		return geographicalArea;
	}

	/** 承保区域 */
	public void setGeographicalArea(String geographicalArea) {
		this.geographicalArea = geographicalArea;
	}

	/** 司法管辖 */
	public String getJudicalScope() {
		return judicalScope;
	}

	/** 司法管辖 */
	public void setJudicalScope(String judicalScope) {
		this.judicalScope = judicalScope;
	}

	/** 争议处理 */
	public String getArgueSolution() {
		return argueSolution;
	}

	/** 争议处理 */
	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	}

	/** 免赔 */
	public String getDeductible() {
		return deductible;
	}

	/** 免赔 */
	public void setDeductible(String deductible) {
		this.deductible = deductible;
	}

	/** 特别约定 */
	public String getClauseconText() {
		return clauseconText;
	}

	/** 特别约定 */
	public void setClauseconText(String clauseconText) {
		this.clauseconText = clauseconText;
	}

	/** 投保说明 */
	public String getAppInstructions() {
		return appInstructions;
	}

	/** 投保说明 */
	public void setAppInstructions(String appInstructions) {
		this.appInstructions = appInstructions;
	}

	/** 健康告知 */
	public String getInform() {
		return inform;
	}

	/** 健康告知 */
	public void setInform(String inform) {
		this.inform = inform;
	}

	/** 条款名称 */
	public String getClauses() {
		return clauses;
	}

	/** 条款名称 */
	public void setClauses(String clauses) {
		this.clauses = clauses;
	}

	/** 条款信息 */
	public EpolicyClausesRoot getClausesList() {
		return clausesList;
	}

	/** 条款信息 */
	public void setClausesList(EpolicyClausesRoot clausesList) {
		this.clausesList = clausesList;
	}

	/** 保险公司 */
	public String getCompany() {
		return company;
	}

	/** 保险公司 */
	public void setCompany(String company) {
		this.company = company;
	}

	/** 经营地址 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/** 经营地址 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/** 电话 */
	public String getTelephone() {
		return telephone;
	}

	/** 电话 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/** 网址 */
	public String getWebsite() {
		return website;
	}

	/** 网址 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/** 重要提示 */
	public String getImportantPart() {
		return importantPart;
	}

	/** 重要提示 */
	public void setImportantPart(String importantPart) {
		this.importantPart = importantPart;
	}

	/** 页脚提示信息 */
	public String getImportantNotice() {
		return importantNotice;
	}

	/** 页脚提示信息 */
	public void setImportantNotice(String importantNotice) {
		this.importantNotice = importantNotice;
	}

	/** 险种代码 */
	public String getRiskCode() {
		return riskCode;
	}

	/** 险种代码 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

}
