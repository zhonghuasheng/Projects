<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminCourse.aspx.cs" Inherits="AdminCourse1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminCourse</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			<asp:Button id="Button2" runat="server" Text="课程信息录入" onclick="Button2_Click"></asp:Button><br/>
			<br/>
			<asp:DataGrid id="DataGrid1" runat="server" AllowPaging="True" Width="613px" 
                AutoGenerateColumns="False" oncancelcommand="DataGrid1_CancelCommand" 
                ondeletecommand="DataGrid1_DeleteCommand" oneditcommand="DataGrid1_EditCommand" 
                onupdatecommand="DataGrid1_UpdateCommand">
				<HeaderStyle BackColor="#CCCC66"></HeaderStyle>
				<Columns>
					<asp:BoundColumn DataField="课程号" ReadOnly="True" HeaderText="课程号"></asp:BoundColumn>
					<asp:BoundColumn DataField="课程名" HeaderText="课程名"></asp:BoundColumn>
					<asp:BoundColumn DataField="先修课" HeaderText="先修课"></asp:BoundColumn>
					<asp:EditCommandColumn ButtonType="LinkButton" UpdateText="更新" CancelText="取消" EditText="编辑"></asp:EditCommandColumn>
					<asp:ButtonColumn Text="删除" CommandName="Delete"></asp:ButtonColumn>
				</Columns>
				<PagerStyle NextPageText="下一页" PrevPageText="上一页"></PagerStyle>
			</asp:DataGrid>
		</form>
      </center>
	</body>
</html>
