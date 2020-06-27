
<h1 style="color:red;text-align:center">Employee Registration Layered Application</h1>

<form action="controller" method="POST">
	<table align="center" border="1" bgcolor="cyan" rows="5" cols="2">
		<tr>
			<td>Employee Number:: </td>
			<td><input type="text" name="eno"></td>
		</tr>
		<tr>
			<td>Employee Name:: </td>
			<td><input type="text" name="ename"></td>
		</tr>
		<tr>
			<td>Employee Addrs:: </td>
			<td><input type="text" name="eaddr"></td>
		</tr>
		<tr>
			<td>Employee Job:: </td>
			<td><input type="text" name="ejob"></td>
		</tr>
		<tr>
			<td>Employee Salary:: </td>
			<td><input type="text" name="esal"></td>
		</tr>
		<tr>
			<td><input type="submit" value="register"></td>
			<td><input type="reset" value="cancel"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="hidden" name="cToken" value="${sToken}"/></td>
		</tr>
	</table>
</form>