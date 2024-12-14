function formatCurrency(amount) {
    return new Intl.NumberFormat('vi-VN').format(amount) + ' đ';
}
function convertToNumber(currencyString) {
    const numberString = currencyString.replace(/\./g, '').replace(' đ', '').trim();
    return parseInt(numberString, 10);
}
var t = 0;
document.getElementById("car-model").addEventListener("change", function () {
    // Lấy option được chọn
    const selectedOption = this.options[this.selectedIndex];
    const carId = selectedOption.value;
    const image = selectedOption.getAttribute("data-image");
    const price = selectedOption.getAttribute("data-price");
    const modalName = selectedOption.textContent.trim(); // Lấy nội dung hiển thị
    document.getElementById('image-car').setAttribute('src',"/vinfast/template/uploads/" + image);
    document.getElementById('giaCongBo').innerText = formatCurrency(price);
    document.getElementById('baoTriDB').innerText = "1.560.000 đ";
    document.getElementById('baoHiem').innerText = "480.700 đ";
    document.getElementById('uuDai').innerText = "0 đ";
    document.getElementById('phiTruocBa').innerText = "0 đ";
    document.getElementById('bienSo').innerText = "20.000.000 đ";
    document.getElementById('dangKiem').innerText = "340.000 đ";
    document.getElementById('khac').innerText = "0 đ";
    var res = eval(price + "+ 1560000+48700+20000000+340000")
    if(t > 0){
        res += t;
    }else{
        t = res;
    }
    document.getElementById('Estimated').innerText = formatCurrency(res);
});
var check = 0;
document.getElementById("battery").addEventListener("change", function () {;
    var selectedValue = this.value
    if(selectedValue == "Bao gồm pin"){
        t = t + 100000000;
        check = 1;
    }else{
        if(check){
            t = t - 100000000;
            check = 0;
        }
    }
    document.getElementById('Estimated').innerText = formatCurrency(t);
})