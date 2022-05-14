<footer class="main-footer">
    <div class="float-right d-none d-sm-block">
        <b>Version</b> 3.1.0
    </div>
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
</footer>
<!-- jQuery -->
<script src="../adminSousce/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../adminSousce/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables  & Plugins -->
<script src="../adminSousce/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../adminSousce/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../adminSousce/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../adminSousce/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="../adminSousce/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="../adminSousce/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="../adminSousce/plugins/jszip/jszip.min.js"></script>
<script src="../adminSousce/plugins/pdfmake/pdfmake.min.js"></script>
<script src="../adminSousce/plugins/pdfmake/vfs_fonts.js"></script>
<script src="../adminSousce/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="../adminSousce/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="../adminSousce/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="../adminSousce/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../adminSousce/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
            "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
        }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
</script>

<!-- form -->

<!-- ./wrapper -->
<!-- jQuery -->
<script src="../adminSousce/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../adminSousce/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jquery-validation -->
<script src="../adminSousce/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="../adminSousce/plugins/jquery-validation/additional-methods.min.js"></script>
<!-- AdminLTE App -->
<script src="../adminSousce/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../adminSousce/dist/js/demo.js"></script>