<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminUrl.aspx.cs" Inherits="AdminUrl1111" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminUrl</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			<font face="宋体"><a href="AdminUrlAdd.aspx">功能模块添加</a>
				<asp:DataGrid id="DataGrid1" runat="server" AutoGenerateColumns="False" 
                AllowPaging="True" onpageindexchanged="DataGrid1_PageIndexChanged">
					<headerStyle BackColor="#CCCC66"></headerStyle>
					<Columns>
						<asp:BoundColumn DataField="Id" headerText="序号">
							<ItemStyle Width="30px"></ItemStyle>
						</asp:BoundColumn>
						<asp:BoundColumn DataField="url" headerText="模块URL">
							<ItemStyle Width="150px"></ItemStyle>
						</asp:BoundColumn>
						<asp:BoundColumn DataField="UrlName" headerText="模块名称">
							<ItemStyle Width="150px"></ItemStyle>
						</asp:BoundColumn>
						<asp:BoundColumn DataField="Comment" headerText="说明">
							<ItemStyle Width="250px"></ItemStyle>
						</asp:BoundColumn>
						<asp:HyperLinkColumn Text="删除" DataNavigateUrlField="id" ItemStyle-Width="30" DataNavigateUrlFormatString="AdminUrlDel.aspx?id={0}"
							headerText="删除" NavigateUrl="AdminUrlDel.aspx"></asp:HyperLinkColumn>
					</Columns>
					<PagerStyle NextPageText="下一页" PrevPageText="上一页"></PagerStyle>
				</asp:DataGrid></font>
		</form>
        </center>
	</body>
</html>
