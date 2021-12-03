import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Sauveteur from "./pages/Sauveteur";
import NotFound from "./pages/NotFound";
import Home from './pages/Home'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/sauveteur" element={<Sauveteur/>} />
        <Route component={NotFound}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
