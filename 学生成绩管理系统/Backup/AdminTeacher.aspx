<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminTeacher.aspx.cs" Inherits="AdminTeacher1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminTeacher</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			<font face="宋体">
				<asp:Button id="Button1" runat="server" Text="添加授课信息" 
                onclick="Button1_Click"></asp:Button><br/>
				<br/>
				<asp:DataGrid id="DataGrid1" runat="server" AllowPaging="True" 
                Width="569px" AutoGenerateColumns="False" 
                oncancelcommand="DataGrid1_CancelCommand" 
                ondeletecommand="DataGrid1_DeleteCommand" oneditcommand="DataGrid1_EditCommand" 
                onpageindexchanged="DataGrid1_PageIndexChanged" 
                onupdatecommand="DataGrid1_UpdateCommand">
					<headerStyle BackColor="#CCCC66"></headerStyle>
					<Columns>
						<asp:BoundColumn DataField="教师名" ReadOnly="True" headerText="教师名"></asp:BoundColumn>
						<asp:BoundColumn DataField="课程号" headerText="课程号"></asp:BoundColumn>
						<asp:BoundColumn DataField="学时数" headerText="学时数"></asp:BoundColumn>
						<asp:BoundColumn DataField="班级名" headerText="班级名"></asp:BoundColumn>
						<asp:EditCommandColumn ButtonType="LinkButton" UpdateText="更新" CancelText="取消" EditText="编辑"></asp:EditCommandColumn>
						<asp:ButtonColumn Text="删除" CommandName="Delete"></asp:ButtonColumn>
					</Columns>
					<PagerStyle NextPageText="下一页" PrevPageText="上一页"></PagerStyle>
				</asp:DataGrid>
			</font>
		</form>
        </center>
	</body>
</html>
