<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminStuAdd.aspx.cs" Inherits="AdminStuAdd1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminStuAdd</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			<table id="Table1" cellspacing="1" cellpadding="1" width="400" border="1">
				<tr>
					<td>学号</td>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<asp:TextBox id="txtsid" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator id="RequiredFieldValidator1" runat="server" ErrorMessage="必填" ControlToValidate="txtsid"></asp:RequiredFieldValidator></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<asp:TextBox id="txtname" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator id="RequiredFieldValidator2" runat="server" ErrorMessage="必填" ControlToValidate="txtname"></asp:RequiredFieldValidator></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<asp:RadioButton id="rbman" runat="server" Text="男" Checked="true" GroupName="sex"></asp:RadioButton>
						<asp:RadioButton id="rbwoman" runat="server" Text="女" GroupName="sex"></asp:RadioButton></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;
						<asp:TextBox id="txtage" runat="server"></asp:TextBox>
						<asp:RangeValidator id="RangeValidator1" runat="server" ErrorMessage="输入无效" ControlToValidate="txtage"
							Type="Integer" MaximumValue="150" MinimumValue="0"></asp:RangeValidator></td>
				</tr>
				<tr>
					<td>院系</td>
					<td>
						<asp:TextBox id="txts" runat="server"></asp:TextBox></td>
				</tr>
				<tr>
					<td>班级名</td>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<asp:TextBox id="txtclassname" runat="server"></asp:TextBox>
						<asp:RequiredFieldValidator id="RequiredFieldValidator3" runat="server" ControlToValidate="txtclassname" ErrorMessage="必填  "></asp:RequiredFieldValidator></td>
				</tr>
				<tr>
					<td>入学年份</td>
					<td>
						<asp:TextBox id="txtyear" runat="server">2001-09-01</asp:TextBox></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<asp:Button id="Button1" runat="server" Text="添 加" onclick="Button1_Click"></asp:Button><font face="宋体">&nbsp;&nbsp;
						</font>
						<asp:Button id="Button2" runat="server" Text="返 回" onclick="Button2_Click"></asp:Button></td>
				</tr>
			</table>
		</form>
        </center>
	</body>
</html>
