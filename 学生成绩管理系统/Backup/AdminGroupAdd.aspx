<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminGroupAdd.aspx.cs" Inherits="AdminGroupAdd1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminGroupAdd</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
				<table id="Table1" cellspacing="1" cellpadding="1" width="300" border="1">
					<tr>
						<td style="WIDTH: 69px">组名称:</td>
						<td>
							<asp:TextBox id="txtGname" runat="server"></asp:TextBox>
							<asp:RequiredFieldValidator id="RequiredFieldValidator1" runat="server" ErrorMessage="必填" ControlToValidate="txtGname"></asp:RequiredFieldValidator></td>
					</tr>
					<tr>
						<td style="WIDTH: 69px">组说明:</td>
						<td>
							<asp:TextBox id="txtGinfo" runat="server"></asp:TextBox></td>
					</tr>
					<tr>
						<td style="WIDTH: 69px"></td>
						<td>
							<asp:Button id="Button1" runat="server" Text="确  定" onclick="Button1_Click"></asp:Button></td>
					</tr>
					<tr>
						<td style="WIDTH: 69px"></td>
						<td></td>
					</tr>
				</table>
		</form>
        </center>
	</body>
</html>
