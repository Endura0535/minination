import React, { useState } from 'react';
import { useNavigation } from '../../../hooks/useNavigation.jsx';
import useMemberApi from '../../../api/useMemberApi.jsx';
import styles from '../Pages/Login.module.css';
import headerLogo from '../../../assets/images/header-logo.png';
import InputBox1 from '../../Common/Atoms/InputBox1.jsx';
import InputBox2 from '../Atoms/InputBox2.jsx';
import ButtonRadio1 from '../../Common/Atoms/ButtonRadio1.jsx';
import ButtonLarge1 from '../../Common/Atoms/ButtonLarge1.jsx';
import MovingLoginOrSignup from '../Atoms/MovingLoginOrSignup.jsx';

const SignupInputForm = () => {
    const { navigateToFoundation, navigateToNationality, navigateToLogin } =
        useNavigation();
    const [name, setName] = useState('');
    const [id, setId] = useState('');
    const [password, setPassword] = useState('');
    const [type, setType] = useState('');
    const [idError, setIdError] = useState('');
    const isButtonDisabled = !id || !name || !password || idError !== '';

    const handleChange1 = event => {
        setName(event.target.value);
    };
    const handleChange2 = event => {
        setId(event.target.value);
    };
    const handleChange3 = event => {
        setPassword(event.target.value);
    };
    const checkDuplication = async () => {
        try {
            const response = await useMemberApi.memberPostId(id);
            if (response.code === 200) {
                setIdError('');
            } else {
                setIdError('중복된 아이디 입니다.');
            }
        } catch (error) {
            console.log(error);
        }
    };
    const postJoinApi = async () => {
        try {
            const response = await useMemberApi.memberPostJoin(
                id,
                password,
                name,
                type,
            );

            if (response.code === 200) {
                if (type === 'ST') {
                    navigateToNationality();
                } else {
                    navigateToFoundation();
                }
            } else {
                console.log(response.code);
            }
        } catch (error) {
            console.log(error);
        }
    };

    return (
        <div className="center">
            <img className={styles.logo} src={headerLogo} alt="logo" />
            <br />
            <InputBox1
                title="이름"
                placeholder="이름"
                inputText={name}
                onChange={handleChange1}
                type="text"
            />
            <br />
            <InputBox2
                placeholder="아이디"
                inputText={id}
                onChange={handleChange2}
                onBlur={checkDuplication}
                type="text"
            />

            {idError && <p className={styles.error}>{idError}</p>}

            <br />
            <InputBox1
                title="비밀번호"
                placeholder="비밀번호"
                inputText={password}
                onChange={handleChange3}
                type="password"
            />
            <br />
            <ButtonRadio1 setData={setType} />
            <br />
            <ButtonLarge1
                title="회원가입"
                onClick={postJoinApi}
                disabled={isButtonDisabled}
            />
            <MovingLoginOrSignup
                description="이미 회원이신가요?"
                title="로그인"
                onClick={navigateToLogin}
            />
        </div>
    );
};

export default SignupInputForm;
