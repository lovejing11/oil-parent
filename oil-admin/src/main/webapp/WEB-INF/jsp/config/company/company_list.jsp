<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>运营管理平台-平台运营设置-频道设置</title>
</head>
<%@ include file="/WEB-INF/jsp/include/include_css.jsp"%>
<%@ include file="/WEB-INF/jsp/include/include_common_css.jsp"%>
<body class=" skin-red-light">
	<!-- Main content -->
	<section class="content wrapper">
		<div class="box box-success">
			<div class="box-header">
				<form id="queryForm" class="form-inline box-body queryForm">
					<div class="col-lg-12">
						<div class="row">
							<div class="form-group input-group-sm">
								<label class="control-label" for="taskName">频道名称</label> 
								<input type="text" name="name" placeholder="输入要搜索的频道名称..." class="form-control">
							</div>
							<div class="form-group input-group-sm">
								<label class="control-label" for="taskName">频道描述</label> 
								<input type="text" name="descritpion" placeholder="输入要搜索的频道描述..." class="form-control">
							</div>
							<div class="form-group input-group-sm">
								<label class="control-label" for="taskName">是否app开启</label> 
								 <select class="form-control aikxian-select2" name="openApp">
									<option value="">未选择</option>
									<option value="true">是</option>
									<option value="false">否</option>
								</select>
							</div>
							<div class="form-group input-group-sm">
								<label class="control-label" for="taskName">是否网站开启</label> 
								 <select class="form-control aikxian-select2" name="openPortal">
									<option value="">未选择</option>
									<option value="true">是</option>
									<option value="false">否</option>
								</select>
							</div>
							<div class="form-group input-group-sm">
								<label class="control-label" for="taskName">是否禁止提问</label> 
								 <select class="form-control aikxian-select2" name="askDisable">
									<option value="">未选择</option>
									<option value="true">是</option>
									<option value="false">否</option>
								</select>
							</div>
							<div class="form-group input-group-sm" style="display:none;">
								<label class="control-label" for="taskName">提问价格</label> 
								<input type="text" class="form-control"  name="askPriceMin" placeholder="从"  >
								- 
								<input type="text" class="form-control"  name="askPriceMax" placeholder="到"  >
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary formSubmit">
									<i class="fa fa-search "></i> 搜索
								</button>
								<button type="reset" class="btn btn-warning formRest">
									<i class="fa fa-reply"></i> 重置
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="box box-info">
			<div class="box-header">
				<div class="btn-group">
					<a class="btn bg-olive" data-toggle="modal" href="${ctx}/platform/config/channel/add" data-target="#modal"> <i class="fa fa-plus"></i> 新增 </a> 
					<a class="btn bg-red" id="batchDel"> <i class="fa fa-remove"></i> 批量删除 </a>
				</div>
			</div>
			<!-- .box-body -->
			<div class="box-body">
				<table class="table datatable table-hover multi table-bordered table-striped">
					<!-- <colspan>
						<col width="80" />
						<col width="80" />
						<col width="100" />
						<col width="120" />
						<col width="80" />
						<col width="120" />
						<col width="120" />
						<col width="100" />
						<col width="100" />
						<col width="100" />
						<col width="80" />
						<col width="80" />
						<col width="100" />
						<col width="120" />
						<col width="200" />
					</colspan>  -->
					<thead>
						<tr>
							<th><input class="checkall" type="checkbox"></th>
							<th>序号</th>
							<th>公司名称</th>
							<th>公司地址</th>					
							<th>是否有效</th>
							<th>修改人</th>
							<th>修改时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</section>
	<!-- /.content -->
	<%@ include file="/WEB-INF/jsp/include/include_js.jsp"%>
	<%@ include file="/WEB-INF/jsp/include/include_common_js.jsp"%>

	<script type="text/javascript">
		$(function() {
			$.dataTable=$('table.table.datatable').dataTable({
				"fnServerData" : function(sSource, aoData,fnCallback) {
					aoData = aoData.concat($("#queryForm").serializeArray());
					$.aikxianPost({
						"url" : "${ctx}/platform/config/company/list",
						"data" : aoData,
						"success" : function(resp) {
							fnCallback(resp);
							$.initIcheck();
						}
					});
				},
				"aoColumns" : [{
						"data" : "id",
						"mRender" : function(data, type,row, cell) {
							return "<input name='id' value='"+data+"' type='checkbox'>";
						}
					},{
						"data" : null,
						"render" : function(data, type,row, cell) {
							return cell.settings._iDisplayStart+ cell.row + 1;
						}
					},{
						"data" : "name"
					},{
						"data" : "address"
					},{
						"data" : "isEnable",
						"render" : function(data, type) {
							var value = " 未设置 ";
							if (data) {
								value = '<span class="label label-success">是</span>';
							} else if (!data) {
								value = '<span class="label label-danger">否</span>';
							}
							return value;
						}
					},{
						"data" : "modifyUser"
					},{
						"data" : "modifyTime"
					},{
						"data" : null,
						"render" : function(data, type,full, cell) {
							var rowButton = '<div class="btn-group"><a class="btn btn-sm bg-purple" data-toggle="modal" href="${ctx}/platform/config/channel/view/'+full.id+'" data-target="#modal"><i class="fa fa-eye"></i> 查看</a>&nbsp;'
							+ '<a class="btn btn-sm bg-orange" data-toggle="modal" href="${ctx}/platform/config/channel/edit/'+full.id+' " data-target="#modal"><i class="fa fa-edit"></i> 修改 </a>&nbsp;'
							+ '<a class="btn btn-sm bg-red delItem" data-id='+full.id+'> <i class="fa fa-remove"></i> 删除 </a></div>';
							return rowButton;
						}
					}]
			});

			$("#batchDel").click(function() {
				var checkrow = $("table.table.datatable tr .checked input[name=id]");
				if (checkrow.length == 0) {
					$.showError('请选择至少一条数据');
					return;
				}
				$.showConfirm('确认批量刪除吗？', function() {
					$.aikxianPost({
						"url" : "${ctx}/platform/config/channel/batchDel",
						"data" : checkrow.serializeArray(),
						"success" : function(resp) {
							if ($.dataTable) {
								$.dataTable.fnDraw();
							}
							$.closeMsg();
						}
					});
				});
			});
			$("table.table.datatable").on("click", "a.delItem", function() {
				var data_id = $(this).attr("data-id");
				$.showConfirm('确认刪除吗？', function() {
					$.aikxianPost({
						"url" : "${ctx}/platform/config/channel/delItem",
						"data" : {
							id : data_id
						},
						"success" : function(resp) {
							if ($.dataTable) {
								$.dataTable.fnDraw();
							}
							$.closeMsg();
						}
					});
				});
			});
		});
	</script>

	<%@ include file="/WEB-INF/jsp/include/include_modal.jsp"%>
</body>
</html>
