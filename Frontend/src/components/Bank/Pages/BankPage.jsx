import React from 'react';
import './BankPage.css';
import NavBar from '../../Common/Organisms/NavBar.jsx';
import BankBar from '../Organisms/BankBar.jsx';
import BankCard from '../Organisms/BankCard.jsx';
import BankContent from '../Organisms/BankContent.jsx';

const BankPage = () => {
    return (
        <div className="bankPageContainer">
            <NavBar username="준혁" totalBalance="30000" />
            <BankBar />
            <BankCard />
            <BankContent />
        </div>
    );
};

export default BankPage;
