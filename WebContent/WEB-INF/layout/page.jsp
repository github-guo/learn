<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<html>
<head>
<title>spittr</title>
</head>
<body>
	<div id="header">
		<t:insertAttribute name="header" />
	</div>
	<div id="content">
		<t:insertAttribute name="body" />
	</div>
	<div id="footer">
		<t:insertAttribute name="footer" />
	</div>
</body>
</html>