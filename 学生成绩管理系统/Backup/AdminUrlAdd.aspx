<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminUrlAdd.aspx.cs" Inherits="AdminUrlAdd1111" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminUrlAdd</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			<font face="宋体"></font>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<table align="center" id="Table1" cellspacing="1" cellpadding="1" width="300" border="0">
				<tr>
					<td style="WIDTH: 110px"><font face="宋体"></font></td>
					<td></td>
				</tr>
				<tr>
					<td style="WIDTH: 110px"><font face="宋体">功能模块名称</font></td>
					<td>
						<asp:TextBox id="txtname" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator id="RequiredFieldValidator1" runat="server" ErrorMessage="必填" ControlToValidate="txtname"></asp:RequiredFieldValidator></td>
				</tr>
				<tr>
					<td style="WIDTH: 110px"><font face="宋体">功能模块URL</font></td>
					<td>
						<asp:TextBox id="txturl" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator id="RequiredFieldValidator2" runat="server" ErrorMessage="必填" ControlToValidate="txturl"></asp:RequiredFieldValidator></td>
				</tr>
				<tr>
					<td style="WIDTH: 110px"><font face="宋体">功能模块说明</font></td>
					<td>
						<asp:TextBox id="TextBox3" runat="server"></asp:TextBox></td>
				</tr>
				<tr>
					<td style="WIDTH: 110px"></td>
					<td>
						<asp:Button id="Button1" runat="server" Text="确  定" onclick="Button1_Click"></asp:Button></td>
				</tr>
			</table>
		</form>
        </center>
	</body>
</html>
