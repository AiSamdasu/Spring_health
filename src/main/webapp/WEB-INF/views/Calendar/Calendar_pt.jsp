<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="calendar-grid">
    <div class="calendar-header"></div>
    <div class="calendar-header">월</div>
    <div class="calendar-header">화</div>
    <div class="calendar-header">수</div>
    <div class="calendar-header">목</div>
    <div class="calendar-header">금</div>
    <div class="calendar-header">토</div>
    <div class="calendar-header">일</div>
    <div class="calendar-header">주별 칼로리</div>
</div>

<c:forEach var="week" begin="1" end="5">
    <div class="calendar-grid">
        <div class="week-label">${week}주</div>
        <c:forEach var="day" begin="1" end="7">
            <div class="day-cell">
                <button class="open-modal" data-day="${(week-1)*7 + day}">+</button>
                <div class="box"></div>
                <div class="cell-text"></div>
            </div>
        </c:forEach>
        <div class="week-total"></div>
    </div>
</c:forEach>

<div class="month-total">1달칼로리 = 999 KCal</div>
