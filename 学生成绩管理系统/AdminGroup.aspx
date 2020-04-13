<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminGroup.aspx.cs" Inherits="AdminGroup1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminGroup</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
				<table id="Table1" cellspacing="1" cellpadding="1" width="500" border="1">
					<tr>
						<td>请选择组:
							<asp:DropDownList id="DropDownList1" runat="server" AutoPostBack="True" 
                                onselectedindexchanged="DropDownList1_SelectedIndexChanged"></asp:DropDownList>&nbsp;&nbsp;&nbsp;&nbsp;
							<asp:Label id="Label1" runat="server"></asp:Label>&nbsp;
							<asp:Button id="Button2" runat="server" Text="删除所选组" onclick="Button2_Click"></asp:Button>&nbsp;
							<asp:Button id="Button1" runat="server" Text="添加新组" onclick="Button1_Click"></asp:Button></td>
					</tr>
					<tr>
						<td>
							<asp:DataGrid id="DataGrid1" runat="server" AutoGenerateColumns="False" Width="440px" AllowPaging="True">
								<HeaderStyle BackColor="#CCCC66"></HeaderStyle>
								<Columns>
									<asp:TemplateColumn HeaderText="选择">
										<ItemTemplate>
											<asp:CheckBox ID="chkExPort" Checked="false" runat="server"></asp:CheckBox>
										</ItemTemplate>
										<EditItemTemplate>
											<asp:CheckBox ID="chkExPortON" Runat="server"></asp:CheckBox>
										</EditItemTemplate>
									</asp:TemplateColumn>
									<asp:BoundColumn DataField="id" HeaderText="序号"></asp:BoundColumn>
									<asp:BoundColumn DataField="UrlName" HeaderText="功能模块"></asp:BoundColumn>
									<asp:BoundColumn DataField="Url" HeaderText="Url地址"></asp:BoundColumn>
								</Columns>
								<PagerStyle NextPageText="下一页" PrevPageText="上一页"></PagerStyle>
							</asp:DataGrid></td>
					</tr>
					<tr>
						<td>
							<asp:Button id="cmdSelectAll" runat="server" Text="全选" 
                                onclick="cmdSelectAll_Click"></asp:Button>
							<asp:Button id="cmdSP" runat="server" Text="设置权限" onclick="cmdSP_Click"></asp:Button><FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								(注:超级管理组不可删除!)</FONT></td>
					</tr>
				</table>
		</form>
        </center>
	</body>
</html>
