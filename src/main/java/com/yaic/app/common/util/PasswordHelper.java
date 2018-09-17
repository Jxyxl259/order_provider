package com.yaic.app.common.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.yaic.app.common.dto.domain.UserDto;

@Service
public class PasswordHelper {

    @SuppressWarnings("unused")
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "SHA1";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(UserDto userDto) {

        String newPassword = new SimpleHash(algorithmName, userDto.getPassword(), ByteSource.Util.bytes(userDto
                .getCredentialsSalt()), hashIterations).toHex();

        userDto.setPassword(newPassword);
    }

    /**
     * 获取用户密码加密后字符串
     * （用于匹配密码是否相等）
     * <p>Author:lujicong
     * <p>Date: 2015-12-10
     * <p>Version: 1.0
     * @param userDefDto
     * @return
     */
    public String getEncryptPassword(UserDto userDto) {

        String newPassword = new SimpleHash(algorithmName, userDto.getPassword(), ByteSource.Util.bytes(userDto
                .getCredentialsSalt()), hashIterations).toHex();

        return newPassword;
    }

    public static void main(String[] agrs) {

        // 加密
        UserDto userDto = new UserDto();
        userDto.setUserCode("001");
        userDto.setPassword("001");
        String newPassword = new SimpleHash("SHA1", userDto.getPassword(), ByteSource.Util.bytes(userDto.getCredentialsSalt()), 2).toHex();
        System.out.println(newPassword);

        // 匹配
        String newPasswordOld = new SimpleHash("SHA1", "1", ByteSource.Util.bytes(userDto.getCredentialsSalt()), 2)
                .toHex();
        System.out.println(newPasswordOld);
    }
}
