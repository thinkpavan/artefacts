<%@taglib uri="colortag" prefix="my"%>
<html>
<body>
 <h1>
  <my:color value="blue">
     This is Blue Color.<br>
     <my:color>
       This should be red.
     </my:color><br>
     This is<%="This is blue again"%>
  </my:color>
 </h1>
</body>
</html>