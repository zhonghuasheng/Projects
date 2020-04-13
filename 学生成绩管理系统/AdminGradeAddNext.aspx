<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminGradeAddNext.aspx.cs" Inherits="AdminGradeAddNext1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminGradeAddNext</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	    <style type="text/css">
            .style1
            {
                height: 27px;
            }
        </style>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			<table id="Table1" 
				cellspacing="1" cellpadding="1" width="288" border="1">
				<tr>
					<td><font face="宋体">课程号</font></td>
					<td>
						<asp:TextBox id="txtcid" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator id="RequiredFieldValidator1" runat="server" ErrorMessage="必填" ControlToValidate="txtcid"></asp:RequiredFieldValidator>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
				</tr>
				<tr>
					<td class="style1"><font face="宋体">成&nbsp; 绩</font></td>
					<td class="style1">
						<asp:TextBox id="txtgrade" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator id="RequiredFieldValidator2" runat="server" ErrorMessage="必填" ControlToValidate="txtgrade"></asp:RequiredFieldValidator>
						<asp:RangeValidator id="RangeValidator1" runat="server" ErrorMessage="输入无效" ControlToValidate="txtgrade"
							Type="Integer" MaximumValue="100" MinimumValue="0"></asp:RangeValidator></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<asp:Button id="Button1" runat="server" Text="确 定" onclick="Button1_Click"></asp:Button></td>
				</tr>
			</table>
		</form>
        </center>
	</body>
</html>
