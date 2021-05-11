<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적표</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<style>
table, tr, td, th {
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse
}
</style>

<style>
td input {
	text-align: center
}
</style>
</head>
<body>
	<table id ="tableId">
		<thead style="backgroud-color: lightgray">
			<tr style="backgroud-color: lightgray">
				<td rowspan="2">전공</td>
				<td rowspan="2">이름</td>
				<td colspan="3">전공과목</td>
				<td id="tdh1" colspan="3">교양 필수 과목</td>
			</tr>
			<tr id = "tr1" style="backgroud-color: lightgray">
				<td>전산학개론</td>
				<td>자바</td>
				<td>프로그래밍</td>
			
					<td id="tdh2">통계학</td>
					<td id="tdh3">전산영어</td>
					<td id="tdh4">전산수학</td>
			</tr>
		</thead>

		<tbody id = "tbodyId">
			<c:forEach var="sungjuk" items="${sungjuk}" varStatus="i">
				<tr>

					<c:if test="${i.count eq 1}">
						<td rowspan="5">컴공</td>
						<!--  // 전공 -->
					</c:if>

					<c:if test="${i.count == 6}">
						<td rowspan="5">비컴공</td>
						<!--  // 전공 -->
					</c:if>


					<td>${sunjuk.name}</td>
					<!-- // 이름 -->
					<td>${sunjuk.junge}</td>
					<!-- // 전산학개론 -->
					<td>${sunjuk.java}</td>
					<!-- // 자바 -->
					<td>${sunjuk.program}</td>
					<!-- // 프로그래밍  -->
					
						<td id="tdt${i.count}">${sunjuk.tongge}</td>
						<!-- // 통계학 -->
						<td id="tde${i.count}">${sunjuk.juneng}</td>
						<!-- // 전산영어 -->
						<td id="tdc${i.count}">${sunjuk.junCal}</td>
						<!-- // 전산수학 -->
						<td id="tds${i.count}">${sunjuk.junSec}</td>
						<!-- // 전공 과목 -->

				<c:set var="junge_total" value="${junge_total + sunjuk.junge}"/>
				<c:set var="java_total" value="${java_total + sunjuk.java}"/>
				<c:set var="pg_total"    value="${pg_total + sunjuk.program}"/>	
				<c:set var="tongge_total" value="${tongge_total + sunjuk.tongge}"/>	
				<c:set var="junEng_total" value="${junEng_total + sunjuk.juneng}"/>	
				<c:set var="junCal_total" value="${junCal_total + sunjuk.junCal}"/>

				</tr>
			</c:forEach>
		</tbody>

		<tfoot>
			<tr>
				<th colspan="2">합계</th>
				<th id="td1"><c:out value="${junge_total}"/></th>
				<th id="td1"><c:out value="${java_total}"/></th>
				<th id="td1"><c:out value="${pg_total}"/></th>
				
				<th id="tdf1"><c:out value="${tongge_total}"/></th>
				<th id="tdf2"><c:out value="${junEng_total}"/></th>
				<th id="tdf3"><c:out value="${junCal_total}"/></th>	

			</tr>
		</tfoot>

	</table>
</body>
</html>