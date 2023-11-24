<%--
  Class Name : login.jsp 
  Description : 메인화면
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2023.11.16   jeong       경량환경 버전 생성
 
    author   : s-onsystem
    since    : 2023.11.16 
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login - CMS System</title>
        <link href="${pageContext.request.contextPath}/sb-admin/css/styles.css" rel="stylesheet" />
		<link rel="stylesheet" href="<c:url value='/'/>css/base.css">
		<link rel="stylesheet" href="<c:url value='/'/>css/layout.css">
		<link rel="stylesheet" href="<c:url value='/'/>css/component.css">
		<link rel="stylesheet" href="<c:url value='/'/>css/page.css">
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>		
		<script src="<c:url value='/'/>js/jquery-1.11.2.min.js"></script>
		<script src="<c:url value='/'/>js/ui.js"></script>  
        <script type="text/javaScript" language="javascript" defer="defer">    
			function fnLoginAction() {
				
				let usrId = document.getElementById("usrId").value;
				let usrPwd = document.getElementById("usrPwd").value;
				
				console.log("usrId : " + usrId);
				console.log("usrPwd : " + usrPwd);
				
				// POST 요청 (/cmm/api/auth/login)
				fetch('/cmm/api/auth/login-jwt', {
				  method: 'POST', // HTTP 메서드
				  headers: {
				    'Content-Type': 'application/json', // 요청 헤더
				  },
				  body: JSON.stringify({ // 요청 본문
					'userSe' : 'USR',
				    'id': usrId,
				    'password': usrPwd
				  }),
				})
				  .then(response => {
				        if (!response.ok) {
				            throw new Error('Network response was not ok');
				        }
				        return response.json(); // 또는 다른 방식으로 응답을 처리
				  })
				  .then(data => {
					  console.log(data);
					  location.href = "/mng/main/mainPageView.do";
				  })
				  .catch(error => console.error('Fetch error:', error))
				
			}
        </script>		    
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">로그인</h3></div>
                                    <div class="card-body">
                                        <form id="frm" name="frm" onsubmit="return false;">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="usrId" type="text" />
                                                <label for="id">ID</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="usrPwd" type="password" />
                                                <label for="password">Password</label>
                                            </div>
                                            <div class="form-check mb-3">
                                                <input class="form-check-input" id="checkRememberPassword" type="checkbox" value="" />
                                                <label class="form-check-label" for="checkRememberPassword">Remember Password</label>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="password.html">Forgot Password?</a>
                                                <a class="btn btn-primary" href="javascript:void(0);" onclick="fnLoginAction(); return false;">Login</a>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="register.html">Need an account? Sign up!</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; s-onsystem 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/sb-admin/js/scripts.js"></script>         
    </body>
</html>
