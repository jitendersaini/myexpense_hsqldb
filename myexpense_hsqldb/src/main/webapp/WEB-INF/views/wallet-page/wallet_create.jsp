<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="dialog-form" title="CREATE PASSWORD WALLET ENTRY">
<!-- <div class="dialog-form" title="Create new category"> -->
	<p style="float: left;" class="validateTips">All fields are required.</p>
	<div id="addremoverows" style="float: right; margin-top: 10px;">
		<button id="addrows">Add Rows</button>		
		<button id="removerows">Remove Rows</button>		
	</div>
	<div style="clear: both;"></div>
	<form:form id="frm" name="frm" modelAttribute="wallet" method="post">
		 <div style="margin-left: 60px;">
			<fieldset id="fieldset">
				<div style="float: left">
					<form:label for="categoryid" path="categoryid">Category Type</form:label>
				</div>
				<div style="float: left; margin-left: 75px;">
					<form:label for="userid" path="userid">User ID</form:label>
				</div>
				<div style="float: left; margin-left: 95px;">
					<form:label for="password" path="password">Password</form:label>
				</div>				
				<div style="float: left;margin-left: 82px;">
					<form:label for="expiryDays" path="expiryDays">Expiry Days</form:label>
				</div>
				<div style="clear:both;height: 5px;"></div>
				<div id="1" class="div_content">
					<div style="float: left;">				
							
					<form:select path="categoryid" class="selectbox ui-widget-content" multiple="single" items="${map}" itemValue="id" itemLabel="categoryName" />
					
					</div>
					<div style="float: left; margin-left: 10px;">	
						<%-- <form:select multiple="single" path="categoryType" items="${map}" class="selectbox ui-widget-content"></form:select> --%>
						<form:input path="userid" size="20" placeholder="Leave blank if N/A"
							class="text_uid ui-widget-content"/>
					</div>
					<div style="float: left; margin-left: 10px;">	
						<form:input path="password" size="20"
							class="text_pass ui-widget-content"/>
					</div>					
					<div style="float: left; margin-left: 10px;">	
						<form:input path="expiryDays" size="10"
							class="text_expdays ui-widget-content"/>
					</div>
					<div style="clear: both;"></div>
				</div>
			</fieldset>
		</div>
	</form:form>
</div>
<script>
$(function() {	
	$("#addremoverows button:first").button({
		icons : {
			primary : "ui-icon-plus"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-close"
		}
	});
	
	$("#addrows").button().click(function() {		
		addrows();		
	});
	$("#removerows").button().click(function() {		
		removerows();		
	});
});
</script>