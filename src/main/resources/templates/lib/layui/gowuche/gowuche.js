(function(window) {
    /**
     * @param {String} prefix	前缀
     * @param {Array} defCart	初始数据 [{name:'',price:1,num:1}]
     */
        //创建ShopCart构造函数
    var ShopCart = function(prefix, defCart) {
            Find.prototype.prefix = prefix;
            //完成购物车中商品的添加
            //通过Cart对象查找class为cart-item的<tr>模板，然后创建了cart对象
            var cart = new Cart(document.getElementsByClassName(prefix)[0]);
            for (var i in defCart) {
                cart.add(defCart[i]); //	添加商品
            }
            cart.updateTotal(); //更新购物车统计（购买的总数量和总价格）

        };

    //
    Cart.prototype = {
        /**
         * 向购物车中添加商品
         * @param {Object} data	商品信息
         */
        add: function(data) {
            var tmp = this.tmp.cloneNode(true); //克隆一个元素节点
            //1.创建购物车中的一件商品对象
            var item = new Item(tmp, data);
            var cart = this;
            //2.添加事件
            item.check.onclick = function() {
                cart.updateTotal();
            };
            item.add.onclick = function() { //增加商品数量
                item.num.textContent = ++item.data.num;
                item.updateSubtotal();
                cart.updateTotal();
            };
            item.reduce.onclick = function() { //减少商品数量
                if (item.data.num > 1) {
                    item.num.textContent = --item.data.num;
                    item.updateSubtotal();
                    cart.updateTotal();
                }else{
                    alert('至少选择1件，如果不需要，请直接删除');
                }
            };
            item.del.onclick = function(){
                if(confirm('您确定要删除此商品吗？')) {		//删除商品
                    tmp.parentNode.removeChild(tmp);	//移出HTML页面中的商品
                    cart.del(item);					//删除items中保存的对应商品
                    cart.updateTotal();
                }
            };
            //3.更新小计，然后将商品对象保存到items中，并插入到item-bottom节点之前
            item.updateSubtotal();
            this.items.push(item);
            this.bottom.before(tmp);
        },

        updateTotal: function(){		//更新购物车统计
            var num = 0,price = 0;
            for(var i in this.items){
                var item = this.items[i];
                if(item.check.checked){
                    num += item.data.num;
                    price += item.data.num * item.data.price;
                }
            }
            this.num.textContent = num;
            this.price.textContent = price.toFixed(2);
        },

        checkAll : function() {	//	全选功能
            for(var i in this.items){
                this.items[i].check.checked = true;
            }
            this.updateTotal();
        },

        del: function(item) {	//删除商品
            for(var i in this.items) {
                if(this.items[i] === item) {
                    delete this.items[i];
                }
            }

        }
    };

    //Item构造函数
    function Item(tmp, data) {
        var find = new Find(tmp); //获取class为cart的div元素对象
        this.check = find.className('check'); //获取商品前的复选框对象
        this.name = find.className('name'); //获取商品名称对象
        this.price = find.className('price'); //获取商品单价对象
        this.num = find.className('num'); //获取商品数量对象
        this.add = find.className('add'); //获取增加商品数量
        this.reduce = find.className('reduce'); //获取减少商品对象
        this.subtotal = find.className('subtotal'); //获取商品小计对象
        this.del = find.className('del'); //获取删除商品对象
        this.data = data;
        //设置商品相关参数
        this.name.textContent = data.name;
        this.price.textContent = data.price.toFixed(2);
        this.num.textContent = data.num;
    }
    Item.prototype = {
        /**
         * 更新小计
         *
         */
        updateSubtotal: function() {
            this.subtotal.textContent = (this.data.num * this.data.price).toFixed(2);
        }
    };

    //Find构造函数表示从哪个元素对象中进行查找
    function Find(obj) {
        this.obj = obj;
    }

    Find.prototype = {
        prefix: '', //prefix属性表示class前缀
        className: function(className) { //className()方法用于根据class查找对应的元素
            return this.obj.getElementsByClassName(this.prefix + '-' + className)[0];
        }
    };

    //编写Cart构造函数，用来创建购物车
    function Cart(obj) {
        this.items = []; //保存所有商品，用于完成购物车的统计、全选以及商品删除的操作
        var find = new Find(obj); //获取class为cart的div对象
        this.all = find.className('all'); //获取全选元素对象
        this.bottom = find.className('bottom'); //获取购物车的统计部分元素对象
        this.num = find.className('total-num'); //获取商品总数
        this.price = find.className('total-price'); //商品总价
        this.tmp = find.className('item'); //获取商品的模板
        this.tmp.parentNode.removeChild(this.tmp); //移出模板
        var cart = this;
        this.all.onclick = function() { //为全选添加单击事件
            cart.checkAll();
        };
    }






    window['ShopCart'] = ShopCart;
})(window);