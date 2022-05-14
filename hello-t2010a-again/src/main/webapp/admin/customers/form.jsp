<%@ page import="com.t2010a.hellot2010aagain.entity.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        Customer customer = (Customer) request.getAttribute("customer");
        int action = (int) request.getAttribute("action");
        String url = "/admin/customers/create";
        if(action == 2){
            url = "/admin/customers/edit";
        }
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create Customer</title>


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
                        <h1>Validation</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Validation</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- jquery validation -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Quick Example <small>jQuery Validation</small></h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <a href="/admin/customers/list">Back to list</a>
                            <form id="quickForm" action="<%=url%>" method="post">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="Id">Id</label>
                                        <input type="tel" name="Id" class="form-control" id="Id" value="<%=customer.getId()%>" <%=action == 2 ?"readonly":""%>>
                                    </div><div class="form-group">
                                    <label for="Name">Full Name</label>
                                    <input type="text" name="Name" class="form-control" id="Name" value="<%=customer.getName()%>">
                                </div>
                                    <div class="form-group">
                                        <label for="Phone">Phone</label>
                                        <input type="text" name="Phone" class="form-control" id="Phone" value="<%=customer.getPhone()%>">
                                    </div><div class="form-group">
                                    <label for="Image">Image</label>
                                    <input type="text" name="Image" class="form-control" id="Image" value="<%=customer.getImage()%>">
                                </div>
                                    <div class="form-group">
                                        <label for="birthday">DOB</label>
                                        <input type="date" name="birthday" class="form-control" id="birthday" value="<%=customer.getDobString()%>">
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Create</button>
                                </div>
                            </form>
                        </div>
                        <!-- /.card -->
                    </div>
                    <!--/.col (left) -->
                    <!-- right column -->
                    <div class="col-md-6">

                    </div>
                    <!--/.col (right) -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>

    <!-- Control Sidebar -->

    <!-- /.control-sidebar -->
</div>

</body>
</html>