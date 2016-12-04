<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/public.jsp"%>
<%@ include file="/WEB-INF/jsp/include/public.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>运营管理平台-平台运营设置-频道设置</title>
</head>
<body class="sidebar-mini skin-red-light">
	<!-- Modal -->
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h4 class="modal-title" id="editModalLabel">频道编辑</h4>
	</div>
	<form class="form-horizontal" id="editForm" method="post"
		action="${ctx}/platform/config/channel/save">
		<input type="hidden" name="id" value="${channel.id}"> <input
			type="hidden" id="picUrl" name="linkIocApp"
			value="${channel.linkIocApp}">

		<div class="box-body modal-body">
			<div class="form-group col-lg-12">
				<label for="name" class="col-lg-2 control-label">频道名称:</label>
				<div class="col-lg-8">
					<input type="text" class="form-control" required
						value="${channel.name}" name="name">
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="orderNum" class="col-lg-2 control-label">排序号:</label>
				<div class="col-lg-8">
					<input type="text" class="form-control" required
						value="${channel.orderNum}" name="orderNum">
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="appIoc" class="col-lg-2 control-label">app图片:</label>
				<div class="col-lg-8">
					<input type="text" class="form-control" required
						value="${channel.appIoc}" name="appIoc">
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="portalIoc" class="col-lg-2 control-label">网站图片:</label>
				<div class="col-lg-8">
					<input type="text" class="form-control" required
						value="${channel.portalIoc}" name="portalIoc">
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="openApp" class="col-lg-2 control-label">app开启:</label>
				<div class="radio col-lg-2">
					<input type="radio" required value="true"
						<c:if test="${empty channel || channel.openApp  }"> checked</c:if>
						name="openApp"> <label>是</label>
				</div>
				<div class="radio col-lg-2">
					<input type="radio" required value="false"
						<c:if test="${!empty channel && !channel.openApp}"> checked</c:if>
						name="openApp"> <label> 否</label>
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="openApp" class="col-lg-2 control-label">网站开启:</label>
				<div class="radio col-lg-2">
					<input type="radio" required value="true"
						<c:if test="${empty channel || channel.openPortal  }"> checked</c:if>
						name="openPortal"> <label>是</label>
				</div>
				<div class="radio col-lg-2">
					<input type="radio" required value="false"
						<c:if test="${!empty channel && !channel.openPortal}"> checked</c:if>
						name="openPortal"> <label> 否</label>
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="openApp" class="col-lg-2 control-label">禁止提问:</label>
				<div class="radio col-lg-2">
					<input type="radio" required value="true"
						<c:if test="${empty channel || channel.askDisable  }"> checked</c:if>
						name="askDisable"> <label>是</label>
				</div>
				<div class="radio col-lg-2">
					<input type="radio" required value="false"
						<c:if test="${!empty channel && !channel.askDisable}"> checked</c:if>
						name="askDisable"> <label> 否</label>
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="openApp" class="col-lg-2 control-label">开启链接按钮:</label>
				<div class="radio col-lg-2">
					<input id="radio_openLinkApp_y" type="radio" required value="true"
						<c:if test="${empty channel || channel.openLinkApp  }"> checked</c:if>
						name="openLinkApp"> <label>是</label>
				</div>
				<div class="radio col-lg-2">
					<input id="radio_openLinkApp_n" type="radio" required value="false"
						<c:if test="${!empty channel && !channel.openLinkApp}"> checked</c:if>
						name="openLinkApp"> <label> 否</label>
				</div>
			</div>
			<div id="linkBut">
				<div class="form-group col-lg-12">
					<label for="openApp" class="col-lg-2 control-label">链接类型:</label>
					<div class="radio col-lg-2">
						<input id="radio_linkType_y" type="radio" required value="true"
							<c:if test="${empty channel || channel.linkType}"> checked</c:if>
							name="linkType"> <label>内链(app内部页面)</label>
					</div>
					<div class="radio col-lg-2">
						<input id="radio_linkType_n" type="radio" required value="false"
							<c:if test="${!empty channel && !channel.linkType}"> checked</c:if>
							name="linkType"> <label>外链(其他网址)</label>
					</div>
				</div>
				<div id="linkUrl_n" class="form-group col-lg-12">
					<label for="adPosition" class="col-lg-2 control-label">内链类型:</label>
					<div class="col-lg-8">
						<select class="form-control aikxian-select2 col-lg-3" required
							name="linkN">
							<option value="STOCK">股票</option>
							<option value="METAL">贵金属</option>
						</select>
					</div>
				</div>
				<div id="linkUrl_w" style="display: none;"
					class="form-group col-lg-12">
					<label for="descritpion" class="col-lg-2 control-label">链接地址:</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" required
							value="${channel.linkW}" name="linkW">
					</div>
				</div>
				<div class="form-group col-lg-12">
					<label for="roleNmae" class="col-lg-2 control-label">图标:</label>
					<div class="col-lg-8">
						<input id="fileImage" type="file" name="fileImage" class="file"
							required onchange="PreviewImg(this);" /> <img id="upImg" alt=""
							style="width: 150px; height: 150px;" src="${channel.linkIocApp}" />
					</div>
				</div>
			</div>
			<div>
				<div class="form-group col-lg-12">
					<label for="openApp" class="col-lg-2 control-label">是否是频道:</label>
					<div class="radio col-lg-2">
						<input id="radio_isChannel_y" type="radio" required value="true"
							<c:if test="${empty channel || channel.isChannel  }"> checked</c:if>
							name="isChannel"> <label>是</label>
					</div>
					<div class="radio col-lg-2">
						<input id="radio_isChannel_n" type="radio" required value="false"
							<c:if test="${!empty channel && !channel.isChannel}"> checked</c:if>
							name="isChannel"> <label> 否</label>
					</div>
				</div>
			</div>
			<div id="parentChanneldiv">
				<div class="form-group col-lg-12">
					<label for="roleNmae" class="col-lg-2 control-label">上级频道:</label>
					<div class="col-lg-8 ">
						<select id="parentId" multiple="multiple"  name="parentId" required  class="form-control select2"></select>
					</div>
				</div>
			</div>

			<div class="form-group col-lg-12">
				<label for="descritpion" class="col-lg-2 control-label">频道描述:</label>
				<div class="col-lg-8">
					<textarea class="form-control" required name="descritpion">${channel.descritpion}</textarea>
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="askType" class="col-lg-2 control-label">提问类型:</label>
				<div class="col-lg-8">
					<input type="text" class="form-control" required
						value="${channel.askType}" name="askType">
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="askPrice" class="col-lg-2 control-label">提问价格:</label>
				<div class="col-lg-8">
					<input type="text" class="form-control" required
						value="${channel.askPrice}" name="askPrice">
				</div>
			</div>
			<div class="form-group col-lg-12">
				<label for="viewpointColor" class="col-lg-2 control-label">观点颜色:</label>
				<div class="col-lg-8">
					<input type="text" class="form-control" required
						value="${channel.viewpointColor}" name="viewpointColor">
				</div>
				eg:#FF00FF
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">
					<i class="fa fa-close "></i>关闭
				</button>
				<button type="submit" class="btn btn-success">
					<i class="fa fa-save "></i>保存
				</button>
			</div>
	</form>
</body>
<script src="${ctx}/resources/common/js/aikxian.common.tools.ajax.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${ctx}/resources/plugins/upyunpai/async.js"></script>
<script src="${ctx}/resources/plugins/jQuery/ajaxfileupload.js"></script>
<script type="text/javascript">
	var flag = true;
	var parentId="";
	$(document).ready(function() {
		if ("${channel.linkIocApp}" != "") {
			$("#fileImage").removeAttr("required");
		}
		$("#radio_openLinkApp_y").click(function() {
			$("#linkBut").show();
		})
		$("#radio_openLinkApp_n").click(function() {
			$("#linkBut").hide();
		})
		$("#radio_linkType_y").click(function() {
			$("#linkUrl_w").hide();
			$("#linkUrl_n").show();
		})
		$("#radio_linkType_n").click(function() {
			$("#linkUrl_w").show();
			$("#linkUrl_n").hide();
		})
		$('#radio_isChannel_y').click(function() {
			$("#parentChanneldiv").show();
		});
		$('#radio_isChannel_n').click(function() {
			$("#parentChanneldiv").hide();
		});
		if ("${channel.isChannel}" == null || "${channel.isChannel}"=='false') {
			$("#parentChanneldiv").hide();
		}else{
			$("#parentChanneldiv").show();
		}
		if ("${channel.openLinkApp}" == 'true') {
			$("#radio_openLinkApp_y").click();

			if ("${channel.linkType}" == 'true') {
				$("#radio_linkType_y").click();
				$("#linkUrl_n").find("option").each(function() {
					if ($(this).val() == "${channel.linkN}") {
						$(this).attr("selected", true);
					}
				})
			} else {
				$("#radio_linkType_n").click();
			}
		} else {
			$("#radio_openLinkApp_n").click();
			$("#radio_linkType_y").click();
		}
		parentId = $('#parentId');
		parentId.select2({
			maximumSelectionLength: 1
		});
		$.getJSON("/platform/config/channel/stairChannel", function(result) {
			parentId.append("<option value='0'>&nbsp;无上级</option>");
			$.each(result.data, function(i, item) {
				if("${channel.id}"!=item.id){
					parentId.append("<option value='"+item.id+"'>&nbsp;" + item.name + "</option>");
				}
			});
			if ("${channel.parentId}" != null && "${channel.parentId}" != "") {
				parentId.val("${channel.parentId}").trigger("change");
			}
		});
	})
	function PreviewImg(obj) {
		var imgPath = URL.createObjectURL(obj.files[0]);
		$("#upImg").next().remove();
		$("#upImg")
				.attr("src", imgPath)
				.after(
						"<a style='margin-left:30px;' class='btn  bg-red' onclick='upImage(this)'> <i class='fa fa-plus'></i>上传</a>");
	}

	function upImage(obj) {
		if (flag) {
			flag = false;
			$
					.ajaxFileUpload({
						url : '${ctx}/system/upYunPic', //用于文件上传的服务器端请求地址
						data : {
							"pathName" : "CHANNEL_PIC_FOLDER"
						},
						secureuri : false, //是否需要安全协议，一般设置为false
						fileElementId : 'fileImage', //文件上传域的ID
						dataType : 'json', //返回值类型 一般设置为json
						success : function(data, status) //服务器成功响应处理函数
						{
							if (data
									&& (data.success == false || data.success == "false")) {
								$.showSystemErrorMsg(data);
							} else {
								$("#fileImage").removeAttr("required");
								flag = true;
								$("#upImg").next().remove();
								$("#upImg")
										.after(
												"<a style='margin-left:30px;' class='btn bg-olive'> <i class='fa fa-plus'></i>上传成功</a>");
								$("#picUrl").val(data.data);
							}
						},
						error : function(data, status, e)//服务器响应失败处理函数
						{
							flag = true;
							$.showSystemErrorMsg(err);
						}
					})
		}
	}
</script>
</html>