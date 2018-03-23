<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="text-center" style="bottom: 0px; background: #ccc;">
	脚注
	<div class="img-thumbnail" id="qr">
		<a href="#" title="￥分享链接￥">￥分享链接￥</a>
	</div>
</div>
<style>
#qr {
	position: fixed;
	z-index: 100;
	left: 10px;
	bottom: 10px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		var qrcode = new QRCode("qr", {
			text : "http://192.168.1.111:8080/pc/",
			width : 100,
			height : 100
		});
	})
</script>