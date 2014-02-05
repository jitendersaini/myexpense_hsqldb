<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="dialog-form" title="CREATE SECURITY Q &amp; A">
	<!-- <div class="dialog-form" title="Create new category"> -->
	<p style="float: left;" class="validateTips">All fields are
		required.</p>
	<div id="addremoverows" style="float: right; margin-top: 10px;">
		<button id="addrows">Add Rows</button>
		<button id="removerows">Remove Rows</button>
	</div>
	<div style="clear: both;"></div>
	<p style="float: right;">ENTRY: ${entryType}</p>
	<form:form id="frm" name="frm" modelAttribute="wallet" method="post">
		<div style="margin-left: 60px;">
			<fieldset id="fieldset">
				<div style="float: left">
					<form:label for="securityQuestion" path="securityQuestion">Security Question</form:label>
				</div>
				<div style="float: left; margin-left: 86px;">
					<form:label for="securityAnswer" path="securityAnswer">Security Answer</form:label>
				</div>
				<div style="clear: both; height: 5px;"></div>
				<div id="1" class="div_content">
					<div style="float: left;">
						<form:hidden path="passwordWalletId" value="${passwordWalletID}" />
						<form:input path="securityQuestion" size="30"
							class="text_qa ui-widget-content" />
					</div>					
					<div style="float: left; margin-left: 10px;">
						<form:input path="securityAnswer" size="30"
							class="text_ans ui-widget-content" />
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