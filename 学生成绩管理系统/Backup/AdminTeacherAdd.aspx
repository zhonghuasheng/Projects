<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminTeacherAdd.aspx.cs" Inherits="AdminTeacherAdd1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminTeacherAdd</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			<font face="宋体">
				<table id="Table1" cellspacing="1" cellpadding="1" width="300" border="1">
					<tr>
						<td>教师名</td>
						<td>
							<asp:TextBox id="txtTname" runat="server"></asp:TextBox></td>
					</tr>
					<tr>
						<td>课程号
						</td>
						<td>
							<asp:TextBox id="txtCid" runat="server"></asp:TextBox></td>
					</tr>
					<tr>
						<td>学时数</td>
						<td>
							<asp:TextBox id="txtTime" runat="server"></asp:TextBox></td>
					</tr>
					<tr>
						<td>班级名</td>
						<td>
							<asp:TextBox id="txtClass" runat="server"></asp:TextBox></td>
					</tr>
					<tr>
						<td style="HEIGHT: 27px"></td>
						<td style="HEIGHT: 27px">
							<asp:Button id="Button1" runat="server" Text="添  加" onclick="Button1_Click"></asp:Button></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
				</table>
			</font>
		</form>
        </center>
	</body>
</html>
