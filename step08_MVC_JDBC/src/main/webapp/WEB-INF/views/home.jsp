<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
session="false" %>
<html>
  <head>
    <title>Home</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  </head>
  <body>
    <div id="result"></div>
    <button id="btn" onclick="alldept()">DEPT</button>
	
	<form action="test">
		<input name="test" id="test" type="text" placeholder="test">
		<input type="submit" value="전달">
	</form>
	
	
    <script>
      function alldept() {
        axios.get('http://localhost:8080/jdbc/api/depts').then((response) => {
          document.getElementById('result').innerHTML = JSON.stringify(
            response.data
          );
          console.log(response.data);
        });
      }

      axios({
      	  method:'post',
      	  url: 'http://localhost:8080/jdbc/api/deptjson',
      	  params: {
      		  deptno : 900,
      		  dname : 'FRONTEND',
      		  loc : 'JEJU'
      	  }
        })
        .then((response) => console.log(response.data));

      /* axios
         .post('http://localhost:8080/jdbc/api/deptjson',
      		   {
      			   deptno : 90,
      	    		  dname : 'FRONTEND',
      	    		  loc : 'JEJU'
      		   }
         )
          .then((response) => console.log(response.data)); */

      /* const params = new URLSearchParams();
          params.append('deptno', 100);
          params.append('dname', 'TEST');
          params.append('loc', 'TEST');

          axios
          .post('http://localhost:8080/jdbc/api/deptjson',params)
           .then((response) => console.log(response.data));  */

      // (JSON) INSERT "/api/deptjson" => deptno : 90, dname : FRONTEND, loc : JEJU
      // (FormEncoded) INSERT "/api/deptjson" => deptno : 100, dname : TEST, loc : TEST
      
      
    </script>
  </body>
</html>
