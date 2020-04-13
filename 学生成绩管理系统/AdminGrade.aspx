<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminGrade.aspx.cs" Inherits="AdminGrade1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminGrade</title>
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
				<br/>
				<br/>
                院系名:<asp:TextBox ID="txt1" runat="server"></asp:TextBox>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                班级名：<asp:TextBox ID="txt2" runat="server"></asp:TextBox>&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:Button ID="search" runat="server" Text="查询" onclick="search_Click" /><br /><br />
				<asp:DataGrid id="DataGrid1" runat="server" AllowPaging="True" 
                AutoGenerateColumns="false" Width="431px" 
                oncancelcommand="DataGrid1_CancelCommand" 
                ondeletecommand="DataGrid1_DeleteCommand" oneditcommand="DataGrid1_EditCommand" 
                onupdatecommand="DataGrid1_UpdateCommand">
					<HeaderStyle BackColor="#CCCC66"></HeaderStyle>
                    <Columns>
                      <asp:BoundColumn DataField="学号" HeaderText="学号" ReadOnly="true"></asp:BoundColumn>
                      <asp:BoundColumn DataField="姓名" HeaderText="姓名" ReadOnly="true"></asp:BoundColumn>
                      <asp:BoundColumn DataField="课程号" HeaderText="课程号" ReadOnly="true"></asp:BoundColumn>
                      <asp:BoundColumn DataField="成绩" HeaderText="成绩"></asp:BoundColumn>
                      <asp:BoundColumn DataField="性别" HeaderText="性别" ReadOnly="true"></asp:BoundColumn>
                      <asp:BoundColumn DataField="班级名" HeaderText="班级名" ReadOnly="true"></asp:BoundColumn>
                      <asp:EditCommandColumn ButtonType="LinkButton" EditText="编辑" UpdateText="更新" CancelText="取消"></asp:EditCommandColumn>
                      <asp:ButtonColumn Text="删除" CommandName="delete"></asp:ButtonColumn>
                    </Columns>
					<PagerStyle NextPageText="下一页" PrevPageText="上一页"></PagerStyle>
				</asp:DataGrid>
			<br />
            <%--<a href="Login.aspx">学生成绩录入</a>--%>
            <%--<asp:Button ID="Button1" runat="server" Text="学生成绩录入" onclick="Button1_Click" />--%>
				<%=button %>
			</font>
		</form>
        </center>
	</body>
</html>
