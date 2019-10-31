<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-integer code="administrator.dashboard.form.label.totalNumberOfAnnouncements" path="totalNumberOfAnnouncements"/>
	<acme:form-integer code="administrator.dashboard.form.label.totalNumberOfCompanyRecords" path="totalNumberOfCompanyRecords"/>
	<acme:form-integer code="administrator.dashboard.form.label.totalNumberOfInvestorRecords" path="totalNumberOfInvestorRecords"/>
	
	
	<!-- Reward -->
	<acme:form-panel code="administrator.dashboard.form.label.rewardInformation">
		<acme:form-double code="administrator.dashboard.form.label.minimumReward" path="minimumReward"/>
		<acme:form-double code="administrator.dashboard.form.label.maximumReward" path="maximumReward"/>
		<acme:form-double code="administrator.dashboard.form.label.averageReward" path="averageReward"/>
		<acme:form-double code="administrator.dashboard.form.label.standardDesviationReward" path="standardDesviationReward"/>
	</acme:form-panel>
	
	<!-- Offer -->
	<acme:form-panel code="administrator.dashboard.form.label.offerInformation">
		<acme:form-double code="administrator.dashboard.form.label.minimumOffer" path="minimumOffer"/>
		<acme:form-double code="administrator.dashboard.form.label.maximumOffer" path="maximumOffer"/>
		<acme:form-double code="administrator.dashboard.form.label.averageOffer" path="averageOffer"/>
		<acme:form-double code="administrator.dashboard.form.label.standardDesviationOffer" path="standardDesviationOffer"/>
	</acme:form-panel>
	
  	<acme:form-return code="administrator.dashboard.form.button.return"/>
</acme:form>
