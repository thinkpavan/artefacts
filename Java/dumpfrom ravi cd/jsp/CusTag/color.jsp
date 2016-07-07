<%@taglib uri="WEB-INF/tlds/color.tld" prefix="my"%>
<html>
<body>
 <h1>
  <my:color value="blue">
     This is Blue Color.<br>
     <my:color value="red">
       This should be red.
     </my:color><br>
     This is<%="blue"%>again.
  </my:color>
 </h1>
</body>
</html>