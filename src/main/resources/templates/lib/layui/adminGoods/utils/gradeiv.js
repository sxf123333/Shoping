
function gradeiv() {
    var province = document.getElementById('province'); // 省份
    var city = document.getElementById('city'); // 市区
    var district = document.getElementById('district'); // 区
    var street = document.getElementById('street'); // 街道

    var provinces = Object.keys(area);// 创建变量接收
    console.log(province);
// 遍历省份
    provinces.forEach(item => {
        var option = document.createElement('option'); // 创建optiin接收省份
        option.innerText = item ; // 将省份内容放到option
        province.appendChild(option); // 将省份放到子节点上输出出去
    });

// province 省级下拉框发生变化 调用下级
    province.onchange = function () {
        console.log(this.value);
        getCity(this.value)
    }


    getCity('河南省'); // 初始化
// city 市级
    function getCity(province) {
        city.innerHTML = ''
        var citys = Object.keys(area[province][0]); // 获取value值和下标为0的郑州市
        // console.log(citys);
        citys.forEach(item => {
            var option = document.createElement('option')
            option.innerText = item;
            city.appendChild(option)
        })
        getDistrict()
    }

//   市级发生变化
    city.onchange = getDistrict; // 市级发生变化调用区级

//   区级发生变化 调用街道
    district.onchange = function () {
        getStreet()
    }



// district 区
    function getDistrict() {
        district.innerHTML = ''
        var districts = area[province.value][0][city.value]
        districts.forEach(item => {
            // console.log(item);
            var dis = Object.keys(item)[0]
            var option = document.createElement('option');
            option.innerText = dis;
            district.appendChild(option)
        });

        getStreet()

    }


// street  街道 需要切割字符串转为数组
    function getStreet() {
        street.innerHTML = ''
        var streets = area[province.value][0][city.value][district.selectedIndex][district.value].split('、');
        console.log(streets);
        streets.forEach(item => {
            // console.log(item[0]);
            var option = document.createElement('option');
            option.innerText = item;
            street.appendChild(option);
        })

    }

}
