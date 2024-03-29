<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table id="cattable" class="display">
	<thead>
		<tr class="even">
			<th><div style="margin-left: 9px;" title="Select All"><input type="checkbox" id="selectAll" class="selectAll"></div></th>
			<th>CATEGORY NAME</th>
			<th>CATEGORY TYPE</th>
			<th>CREATED BY</th>
			<th>MODIFIED BY</th>
			<th>CREATED DATE</th>
			<th>MODIFIED DATE</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${list}" var="v" varStatus="status">
			<tr class="even">
				<td width="1%" align="center"><input type="checkbox" id="rdo" class="rdo" name="rdo"
					value="${v.id}"></td>
				<td>${v.categoryName}</td>
				<td>
					<c:choose>
						<c:when test="${v.categoryType == 1}">
							Expense
						</c:when>
						<c:when test="${v.categoryType == 2}">
							Notification
						</c:when>
						<c:when test="${v.categoryType == 3}">
							Password Wallet
						</c:when>						
					</c:choose>					
				</td>
				<td>${v.usersByCreatedBy.name}<input type="hidden" name="hidUserid" value="${v.usersByCreatedBy.id}"/></td>
				<td>${v.usersByModifiedBy.name}</td>
				<td align="center"><fmt:formatDate value="${v.createdDate}" type="both"/></td>
				<td align="center"><fmt:formatDate value="${v.modifiedDate}" type="both"/></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr class="even">
			<th></th>
			<th>CATEGORY NAME</th>
			<th>CATEGORY TYPE</th>
			<th>CREATED BY</th>
			<th>MODIFIED BY</th>
			<th>CREATED DATE</th>
			<th>MODIFIED DATE</th>
		</tr>
	</tfoot>
</table>

<script>
checkUncheckAll();
</script>