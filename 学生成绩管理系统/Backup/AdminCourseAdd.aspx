<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminCourseAdd.aspx.cs" Inherits="AdminCourseAdd1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminCourseAdd</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
	    <style type="text/css">
            .style1
            {
                height: 24px;
            }
        </style>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
				<table id="Table1" cellspacing="1" cellpadding="1" width="300" border="1">
					<tr>
						<td>课程号</td>
						<td>
							<asp:TextBox id="txtid" runat="server"></asp:TextBox>
							<asp:RequiredFieldValidator id="RequiredFieldValidator1" runat="server" ErrorMessage="必填" ControlToValidate="txtid"></asp:RequiredFieldValidator></td>
					</tr>
					<tr>
						<td>课程名
						</td>
						<td>
							<asp:TextBox id="txtname" runat="server"></asp:TextBox>
							<asp:RequiredFieldValidator id="RequiredFieldValidator2" runat="server" ErrorMessage="必填" ControlToValidate="txtname"></asp:RequiredFieldValidator></td>
					</tr>
					<tr>
						<td class="style1">先修课
						</td>
						<td class="style1">
							<asp:TextBox id="txtpre" runat="server"></asp:TextBox>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<asp:Button id="Button1" runat="server" Text="添  加" onclick="Button1_Click"></asp:Button>&nbsp;
							<asp:Button id="Button2" runat="server" Text="返 回" onclick="Button2_Click"></asp:Button>
						</td>
					</tr>
				</table>
		</form>
        </center>
	</body>
</html>
