/* eslint-disable react/style-prop-object */
import React from 'react';
import './CompanyContent.css';

import KakaoCover from '../../../assets/images/kakao-cover.jpg';

const CompanyContent5 = () => {
    return (
        <div class="company-content-container">
            <div class="company-name">카카오</div>
            <div class="company-image-parent">
                <img
                    src={KakaoCover}
                    alt="카카오배경"
                    class="company-coverimage"
                />
            </div>
            <div class="company-description">
                삼성전자는 전자제품을 만들고 전세계에 판매하는 큰 회사에요.
                판매하는 다양한 물건 중에는 TV, 컴퓨터, 모니터, 냉장고, 세탁기,
                에어컨, 스마트폰, 네트워크 장치, 그리고 컴퓨터와 같은 것들이
                있어요. 또한 작은 컴퓨터 칩과 같은 것들도 만들어요.
            </div>

            <div class="outlink-btns">
                <a
                    href="https://comp.fnguide.com/SVO2/ASP/SVD_Finance.asp?pGB=1&gicode="
                    class="outlink-btn"
                    style={{ textDecoration: 'none' }}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <span class="tooltip">FN가이드 페이지로 이동할께요</span>
                    <span>재무제표</span>
                </a>
                <a
                    href="https://www.samsung.com/sec/"
                    class="outlink-btn"
                    style={{ textDecoration: 'none' }}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <span class="tooltip">제품판매 페이지로 이동할께요</span>
                    <span>제품정보</span>
                </a>
                <a
                    href="https://www.samsung.com/sec/about-us/company-info/"
                    class="outlink-btn"
                    style={{ textDecoration: 'none' }}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <span class="tooltip">기업 홍보 페이지로 이동할께요</span>
                    <span>기업정보</span>
                </a>
            </div>
        </div>
    );
};

export default CompanyContent5;
