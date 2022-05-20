<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.hellot2010aagain.entity.Customer" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        ArrayList<Customer> recentView = (ArrayList<Customer>) session.getAttribute("recentView");
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Customer</title>

    <!-- Google Font: Source Sans Pro -->
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/aside.jsp"></jsp:include>
    <!-- Content Wrapper. Contains page content -->

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">DataTables</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <!-- /.card -->
                        <a href="/admin/customers/list">Back to list</a>
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Recent View</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">

                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Phone</th>
                                        <th>Image</th>
                                        <th>DOB</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <%for (Customer st :recentView) {
                                    %>
                                    <tbody>
                                    <th><%=st.getId()%></th>
                                    <th><%=st.getName()%></th>
                                    <th><%=st.getPhone()%></th>
                                    <th><%=st.getImage()%></th>
                                    <th><%=st.getDobString()%></th>
                                    </tbody>
                                    <%}%>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->

    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->


</body>
</html>