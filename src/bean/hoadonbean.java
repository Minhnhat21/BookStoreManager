package bean;

public class hoadonbean {
	private Long maHoaDon;
	private String maKhachHang;
	private String ngayMua;
	private Boolean daMua;
	
	
	public hoadonbean(Long maHoaDon, String maKhachHang, String ngayMua, Boolean daMua) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
	}
	
	public Long getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(Long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
	public Boolean getDaMua() {
		return daMua;
	}
	public void setDaMua(Boolean daMua) {
		this.daMua = daMua;
	}
	
	
}
