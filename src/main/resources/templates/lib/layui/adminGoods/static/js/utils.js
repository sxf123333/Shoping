function serilizeUrl(url,param) {
    let urlObj = {}
    if (/\?/.test(url)) {
        let urlStr = url.substring(url.indexOf('?') + 1)
        let urlArr = urlStr.split('&')
        let len = urlArr.length

        for (let i = 0; i < len; i++) {
            let urlItem = urlArr[i]
            let item = urlItem.split('=')
            urlObj[item[0]] = item[1]
        }

        return urlObj[param]
    }
}

