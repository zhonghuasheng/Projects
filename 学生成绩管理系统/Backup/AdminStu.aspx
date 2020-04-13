<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminStu.aspx.cs" Inherits="AdminStu1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminStu</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			<asp:Button id="Button1" runat="server" Text="录入学生信息" onclick="Button1_Click"></asp:Button><br/>
			<br/>
			<asp:DataGrid id="DataGrid1" runat="server" AllowPaging="True" 
                AutoGenerateColumns="False" Width="759px" 
                oncancelcommand="DataGrid1_CancelCommand" 
                ondeletecommand="DataGrid1_DeleteCommand" oneditcommand="DataGrid1_EditCommand" 
                onitemcommand="DataGrid1_ItemCommand" onitemdatabound="DataGrid1_ItemDataBound" 
                onpageindexchanged="DataGrid1_PageIndexChanged" 
                onupdatecommand="DataGrid1_UpdateCommand" >
				<HeaderStyle BackColor="#CCCC66"></HeaderStyle>
				<Columns>
					<asp:BoundColumn DataField="学号" ReadOnly="True" HeaderText="学号">
                    </asp:BoundColumn>
					<asp:BoundColumn DataField="姓名" HeaderText="姓名">
					</asp:BoundColumn>
					<asp:BoundColumn DataField="性别" ReadOnly="True" HeaderText="性别">
                    </asp:BoundColumn>
					<asp:BoundColumn DataField="年龄" HeaderText="年龄">
                    </asp:BoundColumn>
					<asp:BoundColumn DataField="所在院系" HeaderText="所在院系">
                    </asp:BoundColumn>
					<asp:BoundColumn DataField="班级名" HeaderText="班级名">
                    </asp:BoundColumn>
					<asp:BoundColumn DataField="入学年份" ReadOnly="True" HeaderText="入学年份">
                    </asp:BoundColumn>
					<asp:EditCommandColumn ButtonType="LinkButton" UpdateText="更新" CancelText="取消" EditText="编辑">
                    </asp:EditCommandColumn>
					<asp:ButtonColumn Text="删除" CommandName="Delete">
                    </asp:ButtonColumn>
				</Columns>
				<PagerStyle NextPageText="下一页" PrevPageText="上一页"></PagerStyle>
			</asp:DataGrid>
		</form>
        </center>
	</body>
</html>
