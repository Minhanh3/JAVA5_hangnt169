<form>
    <h2>Thông tin sản phẩm</h2>
    <div class="mb-3">
        <label for="ma" class="form-label">Mã sản phẩm</label>
        <input type="text" class="form-control" id="ma" name="ma" required>
    </div>
    <div class="mb-3">
        <label for="ten" class="form-label">Tên sản phẩm</label>
        <input type="text" class="form-control" id="ten" name="ten" required>
    </div>

    <h2>Chi tiết sản phẩm</h2>
    <div class="mb-3">
        <label for="idNsx" class="form-label">Nhà sản xuất</label>
        <select class="form-select" id="idNsx" name="idNsx" required>
            <option value="">Chọn nhà sản xuất</option>
            <!-- Các tùy chọn nhà sản xuất -->
        </select>
    </div>
    <div class="mb-3">
        <label for="idMauSac" class="form-label">Màu sắc</label>
        <select class="form-select" id="idMauSac" name="idMauSac" required>
            <option value="">Chọn màu sắc</option>
            <!-- Các tùy chọn màu sắc -->
        </select>
    </div>
    <div class="mb-3">
        <label for="idDongSp" class="form-label">Dòng sản phẩm</label>
        <select class="form-select" id="idDongSp" name="idDongSp" required>
            <option value="">Chọn dòng sản phẩm</option>
            <!-- Các tùy chọn dòng sản phẩm -->
        </select>
    </div>
    <div class="mb-3">
        <label for="namBh" class="form-label">Năm bảo hành</label>
        <input type="number" class="form-control" id="namBh" name="namBh" required>
    </div>
    <div class="mb-3">
        <label for="moTa" class="form-label">Mô tả</label>
        <textarea class="form-control" id="moTa" name="moTa" rows="3"></textarea>
    </div>
    <div class="mb-3">
        <label for="soLuongTon" class="form-label">Số lượng tồn</label>
        <input type="number" class="form-control" id="soLuongTon" name="soLuongTon" required>
    </div>
    <div class="mb-3">
        <label for="giaNhap" class="form-label">Giá nhập</label>
        <input type="number" class="form-control" id="giaNhap" name="giaNhap" required>
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">Giá bán</label>
        <input type="number" class="form-control" id="giaBan" name="giaBan" required>
    </div>
    <button type="submit" class="btn btn-primary">Lưu</button>
</form>