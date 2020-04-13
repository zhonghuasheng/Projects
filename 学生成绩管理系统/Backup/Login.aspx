<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="Login1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>Login</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1" />
		<meta name="CODE_LANGUAGE" content="C#" />
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
		<form id="Form1" method="post" runat="server">
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>
				<table align="center" cellspacing="0" cellpadding="0" width="526" border="0">
					<tr>
						<td colspan="3"><img height="41" alt="" src="images/login_1.jpg" width="526" /></td>
					</tr>
					<tr>
						<td><img height="219" alt="" src="images/login_2.jpg" width="321"/></td>
						<td width="187" height="219">
							<table id="Table3" cellspacing="0" cellpadding="0"  width="187" border="0">
								<tr>
									<td>&nbsp;
										<table id="Table1" cellspacing="1" cellpadding="1" border="0">
											<tr>
												<td>用户名:</td>
												<td>
                                                <asp:TextBox id="txtUsername" runat="server" BorderStyle="Groove" Width="100px"></asp:TextBox>
												</td>
											</tr>
											<tr>
												<td>密&nbsp; 码:</td>
												<td>
													<asp:TextBox id="txtPassword" runat="server" TextMode="Password" BorderStyle="Groove" Width="100px"></asp:TextBox></td>
											</tr>
											<tr>
												<td><asp:Label ID="lab" runat="server"></asp:Label></td>
												<td>
													<asp:Button id="Button1" runat="server" Text="确 定" onclick="Button1_Click"></asp:Button></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						<td><img height="219" alt="" src="images/login_4.jpg" width="18"/></td>
					</tr>
					<tr>
						<td colspan="3"><img height="42" alt="" src="images/login_5.jpg" width="526"/></td>
					</tr>
				</table>
		</form>
	</body>
</html>

