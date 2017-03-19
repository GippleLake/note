/**
 * Created by gipplelake on 2015/5/14.
 */
var text = 'test';
var keySize = 1024;
var crypt = new JSEncrypt({default_key_size: keySize});
var enc = crypt.encrypt(text);