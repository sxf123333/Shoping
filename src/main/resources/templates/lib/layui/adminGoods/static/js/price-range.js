$((function () {
    $("#slider-range").slider({
        range: !0, min: 0, max: 500, values: [75, 300], slide: function (e, a) {
            $("#amount").val("$" + a.values[0] + " - $" + a.values[1])
        }
    }), $("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1))
}));