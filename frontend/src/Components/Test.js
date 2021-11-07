import React, { Component } from 'react';

class Test extends React.Component{
    func1() {
        let arr = [];
        for (let i = 0; i < 3; i++) {
            arr.push(<h1>{i}</h1>);
        }
        return arr;
    }
    render() {
        
        return (
            <div>
                { this.func1() } 
            </div>
        )
    }
}

export default Test;